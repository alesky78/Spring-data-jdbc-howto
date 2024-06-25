package it.spaghettisource.springdatajdbc.howto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * this Spring application has the unique scope to start the h2 console to analyze the data inserted to prepare tests
 * don't use it to runt the tests, each test has a consistent test class to use instead
 * <p>
 * the h2 console is published on this url: http://localhost:8080/h2-console
 */
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }

}
