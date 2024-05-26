package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QueryByAnnotationRootRepository extends ListCrudRepository<QueryByAnnotationRoot,Long> {

    List<QueryByAnnotationRoot> findByName(String name);

    @Query("SELECT * " +
            "FROM QUERY_BY_ANNOTATION_ROOT LEFT OUTER JOIN QUERY_BY_ANNOTATION_NESTED_ONE nested ON nested.QUERY_BY_ANNOTATION_ROOT = QUERY_BY_ANNOTATION_ROOT.ID " +
            "WHERE nested.NESTED_NAME = :nestedName")
    List<QueryByAnnotationRoot> findByNestedName(@Param("nestedName") String name);


}