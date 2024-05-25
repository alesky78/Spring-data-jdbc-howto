package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ConfigurationDefineQueryMethod.class)
@AutoConfigureJdbc
public class SimpleQueryMethodTest {

    private static final Logger logger = LoggerFactory.getLogger(SimpleQueryMethodTest.class);

    @Autowired
    SimpleQueryMethodRepository repository;

    @Test
    void findByParameter_UniqueResult(){
        var element = repository.findByName("Aldric");
        logger.info("element found"+element.get());

        assertThat(element.isPresent()).isTrue();
    }

    /**
     * this test show the usage of the exception IncorrectResultSizeDataAccessException
     * if the return parameter cannot be honored
     */
    @Test
    void MultypleResultNotHonored_Thorw_IncorrectResultSizeDataAccessException(){
        assertThrows(IncorrectResultSizeDataAccessException.class,
                ()->{
                    var element = repository.findByName("Maria");
                    logger.info("element found"+element.get());
                });
    }

    @Test
    void greaterThen(){
        var elements = repository.findByAgeGreaterThan(100);
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void between(){
        var elements = repository.findByAgeBetween(15,25);
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void dateAfter(){
        var elements = repository.findByBirthDateAfter(LocalDate.parse("2020-01-01"));
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void in(){
        var elements = repository.findByJobIn( Arrays.asList("DOCTOR", "DIRECTOR"));
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void not(){
        var elements = repository.findByNameNot("Maria");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void IgnoreCase(){
        var elements = repository.findByNameIgnoreCase("mARIA");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void IgnoreCaseAll(){
        var elements = repository.findByNameAndJobAllIgnoreCase("mARIA","director");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void contain(){
        var elements = repository.findByNameContaining("ari");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

    @Test
    void notContain(){
        var elements = repository.findByNameNotContaining("ari");
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }


}
