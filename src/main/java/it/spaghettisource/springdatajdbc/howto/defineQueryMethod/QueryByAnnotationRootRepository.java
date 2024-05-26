package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QueryByAnnotationRootRepository extends ListCrudRepository<QueryByAnnotationRoot,Long> {

    List<QueryByAnnotationRoot> findByName(String name);

    //not convention respected "Select *" --> Spring wil not populate properly the beans
    @Query("SELECT * " +
            "FROM QUERY_BY_ANNOTATION_ROOT LEFT OUTER JOIN QUERY_BY_ANNOTATION_NESTED_ONE nested ON nested.QUERY_BY_ANNOTATION_ROOT = QUERY_BY_ANNOTATION_ROOT.ID " +
            "WHERE QUERY_BY_ANNOTATION_ROOT.NAME = :name")
    List<QueryByAnnotationRoot> findByName_missingNestedOneMapping(@Param("name") String name);

    //convention respected  --> Spring wil populate properly the beans
    @Query("SELECT QUERY_BY_ANNOTATION_ROOT.ID AS ID, QUERY_BY_ANNOTATION_ROOT.NAME AS NAME, QUERY_BY_ANNOTATION_ROOT.AGE AS AGE, QUERY_BY_ANNOTATION_ROOT.JOB AS JOB, " +
            "nested.QUERY_BY_ANNOTATION_ROOT AS NESTED_QUERY_BY_ANNOTATION_ROOT, nested.NESTED_NAME AS NESTED_NESTED_NAME " +
            "FROM QUERY_BY_ANNOTATION_ROOT LEFT OUTER JOIN QUERY_BY_ANNOTATION_NESTED_ONE nested ON nested.QUERY_BY_ANNOTATION_ROOT = QUERY_BY_ANNOTATION_ROOT.ID " +
            "WHERE QUERY_BY_ANNOTATION_ROOT.NAME = :name")
    List<QueryByAnnotationRoot> findByName_properNestedOneMapping(@Param("name") String name);

    @Query("SELECT QUERY_BY_ANNOTATION_ROOT.ID AS ID, QUERY_BY_ANNOTATION_ROOT.NAME AS NAME, QUERY_BY_ANNOTATION_ROOT.AGE AS AGE, QUERY_BY_ANNOTATION_ROOT.JOB AS JOB, " +
            "nested.QUERY_BY_ANNOTATION_ROOT AS NESTED_QUERY_BY_ANNOTATION_ROOT, nested.NESTED_NAME AS NESTED_NESTED_NAME " +
            "FROM QUERY_BY_ANNOTATION_ROOT LEFT OUTER JOIN QUERY_BY_ANNOTATION_NESTED_ONE nested ON nested.QUERY_BY_ANNOTATION_ROOT = QUERY_BY_ANNOTATION_ROOT.ID " +
            "AND  QUERY_BY_ANNOTATION_ROOT LEFT OUTER JOIN QUERY_BY_ANNOTATION_NESTED_MANY list ON list.QUERY_BY_ANNOTATION_ROOT = QUERY_BY_ANNOTATION_ROOT.ID " +
            "WHERE list.ELEMENT = :element")
    List<QueryByAnnotationRoot> findByElement(@Param("element") String name);


}
