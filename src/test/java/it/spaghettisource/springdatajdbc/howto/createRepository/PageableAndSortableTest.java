package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RepositoryConfiguration.class)
@AutoConfigureJdbc
public class PageableAndSortableTest {

    private static final Logger logger = LoggerFactory.getLogger(PageableAndSortableTest.class);

    @Autowired
    PageableAndSortableRepository repository;


    @Test
    void findPagesBy5(){
        repository.findAll(PageRequest.of(0,5)).forEach(p -> logger.info("element:"+p));
        repository.findAll(PageRequest.of(1,5)).forEach(p -> logger.info("element:"+p));
        repository.findAll(PageRequest.of(2,5)).forEach(p -> logger.info("element:"+p));
        repository.findAll(PageRequest.of(3,5)).forEach(p -> logger.info("element:"+p));

        assertThat(true).isTrue();
    }

    @Test
    void findOverMaxPage(){
        //there are 20 now rows, I want the number 101
        Page<PageableAndSortable> data = repository.findAll(PageRequest.of(1,100));
        assertThat(data.isEmpty()).isTrue();
    }

    @Test
    void findAllSorted(){
        //get all in reverse order
        List<PageableAndSortable> data = repository.findAll(Sort.by(Sort.Direction.DESC, "order"));
        data.forEach(p -> logger.info("element:"+p));
        assertThat(data.isEmpty()).isFalse();
    }

    @Test
    void findAllPagesAndSorted(){

        var sort = Sort.by(Sort.Direction.DESC, "order");

        repository.findAll(PageRequest.of(0,5,sort)).forEach(p -> logger.info("element:"+p));
        repository.findAll(PageRequest.of(1,5,sort)).forEach(p -> logger.info("element:"+p));
        repository.findAll(PageRequest.of(2,5,sort)).forEach(p -> logger.info("element:"+p));
        repository.findAll(PageRequest.of(3,5,sort)).forEach(p -> logger.info("element:"+p));

        assertThat(true).isTrue();
    }

    @Test
    void findAllByQuerySorted(){

        List<PageableAndSortable> data =  repository.findByDiscriminator("B",Sort.by(Sort.Direction.DESC, "order"));
        data.forEach(p -> logger.info("element:"+p));
        assertThat(data.isEmpty()).isFalse();

    }

    @Test
    void findAllByQueryPAgeable(){

        var sort = Sort.by(Sort.Direction.DESC, "order");
        var page = PageRequest.of(0,5,sort);

        List<PageableAndSortable> data =  repository.findByDiscriminator("B",page);
        data.forEach(p -> logger.info("element:"+p));
        assertThat(data.isEmpty()).isFalse();

    }

}
