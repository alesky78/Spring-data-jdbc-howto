package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RepositoryConfiguration.class)
@AutoConfigureJdbc
public class PageableAndSortableTest {

    private static final Logger logger = LoggerFactory.getLogger(PageableAndSortableTest.class);

    @Autowired
    PageableAndSortableRepository repository;

    @Test
    void pageTotalDataInfo(){

        Page<PageableAndSortable> data = repository.findAll(PageRequest.of(0,100));

        logger.info("total pages:"+data.getTotalPages());
        logger.info("total elements:"+data.getTotalElements());
        logger.info("actual slice number:"+data.getNumber());
        logger.info("actual slice element:"+data.getNumberOfElements());
        logger.info("slice size requested:"+data.getSize());
        logger.info("getPageable:"+data.getPageable());

        assertThat(data.getTotalElements()).isGreaterThan(0);
    }

    @Test
    void findPagesBy5(){

        var page = PageRequest.of(0,5);
        repository.findAll(page).forEach(p -> logger.info("element:"+p));
        page = page.next();
        repository.findAll(page).forEach(p -> logger.info("element:"+p));
        page = page.next();
        repository.findAll(page).forEach(p -> logger.info("element:"+p));
        page = page.next();
        repository.findAll(page).forEach(p -> logger.info("element:"+p));
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
    void findAllByDiscriminatorAndQuerySorted(){

        List<PageableAndSortable> data =  repository.findByDiscriminator("B",Sort.by(Sort.Direction.DESC, "order"));
        data.forEach(p -> logger.info("element:"+p));
        assertThat(data.isEmpty()).isFalse();

    }

    @Test
    void findAllByDiscriminatorAndPageable(){

        //alternative Sort.by("order").descending();
        var sort = Sort.by(Sort.Direction.DESC, "order","discriminator");  
        var page = PageRequest.of(0,5,sort);

        Page<PageableAndSortable> data =  repository.findByDiscriminator("B",page);
        data.forEach(p -> logger.info("element:"+p));
        assertThat(data.isEmpty()).isFalse();

    }

    @Test
    void findAllByDiscriminatorAndLimit(){

        var limit = Limit.of(5);

        List<PageableAndSortable> data =  repository.findByDiscriminator("B",limit);
        data.forEach(p -> logger.info("element:"+p));
        assertThat(data.isEmpty()).isFalse();

    }

    @Test
    void findAllBySlice(){

        var page = PageRequest.of(0,5);
        Slice<PageableAndSortable> data =  repository.findByCommon("SAME",page);
        data.forEach(p -> logger.info("element:"+p));

        while(data.hasNext()){
            page = page.next();
            data = repository.findByCommon("SAME",page);
            data.forEach(p -> logger.info("element:"+p));
        }

        assertThat(true).isTrue();

    }

}
