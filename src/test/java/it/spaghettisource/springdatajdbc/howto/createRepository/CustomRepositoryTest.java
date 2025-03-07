package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ConfigurationCreateRepository.class)
@AutoConfigureJdbc
public class CustomRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomRepositoryTest.class);

    @Autowired
    CustomRepository repository;

    @Test
    void forceInsertByFragmentInterface(){

        var created = repository.insert(new Custom(10L, "Data"));
        logger.info("forced INSERT by fragment interface:" + created);

        created = repository.save(created);
        logger.info("standard save:" + created);

        assertThat(created).isNotNull();
    }

    @Test
    void forceUpdateByFragmentInterface(){

        List<Custom> created = repository.findAll();
        logger.info("found all the entities");

        repository.update(created.getFirst());
        logger.info("forced by fragment interface:");

        assertThat(created).isNotNull();
    }

}
