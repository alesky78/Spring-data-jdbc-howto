package it.spaghettisource.springdatajdbc.howto.createRepository;

import org.springframework.data.repository.ListCrudRepository;

public interface CustomRepository extends ListCrudRepository<Custom,Long>, CustomRepositoryInsertFragment<Custom,Long> {

}
