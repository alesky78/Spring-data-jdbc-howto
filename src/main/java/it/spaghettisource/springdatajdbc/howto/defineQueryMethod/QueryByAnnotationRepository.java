package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface QueryByAnnotationRepository extends ListCrudRepository<QueryByAnnotationRoot,Long> {


    List<PropertyExpressionsRoot> findAllByName(String address);


}
