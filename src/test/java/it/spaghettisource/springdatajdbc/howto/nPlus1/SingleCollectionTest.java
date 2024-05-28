package it.spaghettisource.springdatajdbc.howto.nPlus1;

import it.spaghettisource.springdatajdbc.howto.nPlu1.ConfigurationnPlus1;
import it.spaghettisource.springdatajdbc.howto.nPlu1.SingleCollectionRootRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ConfigurationnPlus1.class)
@AutoConfigureJdbc
public class SingleCollectionTest {

    private static final Logger logger = LoggerFactory.getLogger(SingleCollectionTest.class);

    @Autowired
    SingleCollectionRootRepository repository;

   @Test
    public void test() {

        var root = repository.findById(0L);

        assertThat(root.isPresent()).isNotNull();
        logger.info("after save: "+root.get());

    }

    @Test
    public void findAll_SingleManualQuery() {

        var elements = repository.findAllBy_SingleQuery_ByExtractor();
        elements.forEach(e -> logger.info(e.toString()));

        assertThat(elements.size()).isGreaterThan(0);
    }

}
