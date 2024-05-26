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

    /**
     * example to make Spring Data write the query in the log
     * so that can be used to write the SQL to use in the @Query annotation
     */
    @Test
    void findAll(){
        var elements = repository.findAll();
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    /**
     * this example is based on this query  {@link QueryByAnnotationRootRepository#findByName_missingNestedOneMapping(String)}
     * show two important point:
     * 1)   if you have 1 to 1 relationship, in the select clause it is mandatory to define all the alias correctly
     *      to respect the mapping convention or Spring Data JDBC will be not able to map back the row received:
     *      this method will return a null QueryByAnnotationNestedOne also if in the DB it is present
     * 2)   to 1 to M relationship are executed in a different query also if not present in this query Spring will run the separate query related to 1 to M
     */
    @Test
    void findByName_SelectNotRespectedConvention(){
        var elements = repository.findByName_missingNestedOneMapping("Lucas");
        elements.forEach(e -> {logger.info(e.toString());
                               assertThat(e.getNested()).isNull();}
                        );
    }

    /**
     * this example is based on this query  {@link QueryByAnnotationRootRepository#findByName_properNestedOneMapping(String)}
     * show two important point:
     * 1)   if you have 1 to 1 relationship, in the select clause it is mandatory to define all the alias correctly
     *      to respect the mapping convention or Spring Data JDBC will be not able to map back the row received:
     *      this method will return a proper QueryByAnnotationNestedOne
     * 2)   to 1 to M relationship are executed in a different query also if not present in this query Spring will run the separate query related to 1 to M
     */
    @Test
    void findByName_properNestedOneMapping(){
        var elements = repository.findByName_properNestedOneMapping("Lucas");
        elements.forEach(e -> {logger.info(e.toString());
                                assertThat(e.getNested()).isNotNull();}
        );
    }

    /**
     * this example is based on this query  {@link QueryByAnnotationRootRepository#findByElement(String)}
     * show two important point:
     * 1)   if you have 1 to M relationship and write a complex query to analyse the condition in the M part of the relationship if a record is found
     *      the query on the 1 to M relationship are executed again in a different query
     */
    @Test
    void findByElement_properNestedOneMapping(){
        var elements = repository.findByElement("other first element");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

}
