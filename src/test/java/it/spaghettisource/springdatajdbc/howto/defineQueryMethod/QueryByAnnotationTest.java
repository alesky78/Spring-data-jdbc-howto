package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ConfigurationDefineQueryMethod.class)
@AutoConfigureJdbc
public class QueryByAnnotationTest {

    private static final Logger logger = LoggerFactory.getLogger(QueryByAnnotationTest.class);

    @Autowired
    QueryByAnnotationRootRepository repository;


    @Test
    void findByName(){
        var elements = repository.findByName("Lucas");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void findByNestedName(){
        var elements = repository.findByNestedName("nested one");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }





}
