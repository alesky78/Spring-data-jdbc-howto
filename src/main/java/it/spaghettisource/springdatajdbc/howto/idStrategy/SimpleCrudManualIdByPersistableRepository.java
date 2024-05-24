package it.spaghettisource.springdatajdbc.howto.idStrategy;

import org.springframework.data.repository.ListCrudRepository;

public interface SimpleCrudManualIdByPersistableRepository extends ListCrudRepository<SimpleCrudManualIdByPersistable,String> {

}
