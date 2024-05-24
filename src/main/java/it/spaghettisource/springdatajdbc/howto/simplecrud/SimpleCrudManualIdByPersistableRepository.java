package it.spaghettisource.springdatajdbc.howto.simplecrud;

import org.springframework.data.repository.ListCrudRepository;

public interface SimpleCrudManualIdByPersistableRepository extends ListCrudRepository<SimpleCrudManualIdByPersistable,String> {

}
