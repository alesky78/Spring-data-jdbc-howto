package it.spaghettisource.springdatajdbc.howto.idStrategy;

import org.springframework.data.repository.ListCrudRepository;

public interface SimpleCrudVersionedRepository extends ListCrudRepository<SimpleCrudVersioned,Long> {
}
