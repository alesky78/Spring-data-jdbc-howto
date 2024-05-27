package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = ConfigurationDefineQueryMethod.class)
@AutoConfigureJdbc
public class ModifyByQueryAnnotationTest {

    private static final Logger logger = LoggerFactory.getLogger(ModifyByQueryAnnotationTest.class);

    @Autowired
    ModifyByQueryAnnotationRepository repository;

    @Test
    void updateName_NoVersionChange(){

        var element = repository.findByName("Marc");
        Long version = element.getVersion();
        logger.info("before update: "+element);

        boolean update = repository.updateNameNoVersionManaged(element.getId(),"UPDATE");
        assertThat(update).isTrue();

        element = repository.findByName("UPDATE");
        logger.info("after update: "+element);

        assertThat(version == element.getVersion()).isTrue();

    }

    @Test
    void updateName_VersionChange(){

        var element = repository.findByName("Alex");
        Long version = element.getVersion();
        logger.info("before update: "+element);

        boolean update = repository.updateNameVersionManaged(element.getId(), 1L, "VERSIONED");
        assertThat(update).isTrue();

        element = repository.findByName("VERSIONED");
        logger.info("after update: "+element);

        assertThat(version != element.getVersion()).isTrue();

    }

    @Test
    void updateName_VersionNotRespected_DontThrowOptimisticLockingFailureException(){

        var element = repository.findByName("Lucas");
        Long version = element.getVersion();
        logger.info("before update: "+element);

        boolean update = repository.updateNameVersionManaged(element.getId(), 0L, "VERSIONED");
        logger.info("update executed?: "+update);
        assertThat(update).isFalse();

    }

    @Test
    void updateName_VersionNotRespected_ThrowOptimisticLockingFailureException(){

        assertThrows(OptimisticLockingFailureException.class,
                ()->{
                    var element = repository.findByName("Maria");
                    Long version = element.getVersion();
                    logger.info("before update: "+element);

                    if(!repository.updateNameVersionManaged(element.getId(), 0L, "VERSIONED")) {
                        throw new OptimisticLockingFailureException("version doesn't match");
                    }
                });
    }


}
