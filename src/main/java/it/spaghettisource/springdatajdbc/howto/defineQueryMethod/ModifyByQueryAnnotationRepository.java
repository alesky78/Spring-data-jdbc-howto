package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ModifyByQueryAnnotationRepository extends ListCrudRepository<ModifyByQueryAnnotation,Long> {


    ModifyByQueryAnnotation findByName(String name);

    @Modifying
    @Query("UPDATE MODIFY_BY_QUERY_ANNOTATION SET name = :name WHERE id = :id")
    boolean updateNameNoVersionManaged(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Query("UPDATE MODIFY_BY_QUERY_ANNOTATION SET name = :name , VERSION = :version +1 WHERE id = :id and version = :version")
    boolean updateNameVersionManaged(@Param("id") Long id, @Param("version") Long version, @Param("name") String name);

}
