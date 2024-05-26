package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ConfigurationDefineQueryMethod.class)
@AutoConfigureJdbc
public class QueryByAnnotationTest {

    private static final Logger logger = LoggerFactory.getLogger(QueryByAnnotationTest.class);

    @Autowired
    QueryByAnnotationRootRepository repository;


    @Test
    void create(){

        var embedded =  new QueryByAnnotationEmbeddedOne();
        embedded.setAge(23);
        embedded.setJob("STUDENT");

        var nested = new QueryByAnnotationNestedOne();
        nested.setNestedName("Nested bean created");

        var nestedMany1 = new QueryByAnnotationNestedMany();
        var nestedMany2 = new QueryByAnnotationNestedMany();
        var nestedMany3 = new QueryByAnnotationNestedMany();

        nestedMany1.setElement("element 1");
        nestedMany2.setElement("element 2");
        nestedMany3.setElement("element 3");
        Set<QueryByAnnotationNestedMany> set = new HashSet<QueryByAnnotationNestedMany>();
        set.add(nestedMany1);
        set.add(nestedMany2);
        set.add(nestedMany3);

        var root = new QueryByAnnotationRoot();
        root.setName("Root");
        root.setEmbedded(embedded);
        root.setNested(nested);
        root.setList(set);

        root = repository.save(root);
        logger.info("save executed:"+root.toString());

        var list = repository.findByName("Root"); //Lucas Root
        list.forEach(e -> logger.info("find executed:"+e.toString()));

        assertThat(true).isTrue();
    }

    @Test
    void findAll(){
        var elements = repository.findAll();
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void findByNestedName(){
        var elements = repository.findByNestedName("nested 1");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }





}
