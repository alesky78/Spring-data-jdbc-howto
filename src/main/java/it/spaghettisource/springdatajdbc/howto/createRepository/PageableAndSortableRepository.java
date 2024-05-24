package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.List;

public interface PageableAndSortableRepository extends CrudRepository<PageableAndSortable,Long>, ListPagingAndSortingRepository<PageableAndSortable,Long> {

    /**
     * example of sorting by query composition
     */
    List<PageableAndSortable> findByDiscriminator(String discriminator, Sort sort);

    /**
     * example of pageable by query composition
     */
    List<PageableAndSortable> findByDiscriminator(String discriminator, Pageable pageable);

}
