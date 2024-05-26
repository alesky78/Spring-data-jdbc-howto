package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ConfigurationDefineQueryMethod.class)
@AutoConfigureJdbc
public class PropertyExpressionsRootTest {

    private static final Logger logger = LoggerFactory.getLogger(QueryByMethodTest.class);

    @Autowired
    PropertyExpressionRootRepository repository;

    @Test
    void findByRootProperty(){

        var elements = repository.findAllByName("Aldric");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);

    }

//    @Test
//    void findByNestedProperty(){
//
//        var elements = repository.findAllByNested_Address("Boulevard General Louis");
//        elements.forEach(e -> logger.info(e.toString()));
//
//        assertThat(elements.size()).isGreaterThan(0);
//
//    }

    @Test
    void findByNestedPropertyUsingQueryAnnotation(){

        var elements = repository.findAllByNested_AddressWithQueryAnnotation("Boulevard General Louis");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);

    }




}
