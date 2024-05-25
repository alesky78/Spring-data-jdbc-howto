package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SimpleQueryMethodRepository extends ListCrudRepository<SimpleQueryMethod,Long> {

    Optional<SimpleQueryMethod> findByName(String name);

    List<SimpleQueryMethod> findByAgeGreaterThan(int age) ;

    List<SimpleQueryMethod> findByAgeBetween(int from, int to);

    List<SimpleQueryMethod> findByBirthDateAfter(LocalDate date);

    List<SimpleQueryMethod> findByJobIn(Collection<String> jobs);

    List<SimpleQueryMethod> findByNameNot(String name);

    List<SimpleQueryMethod> findByNameIgnoreCase(String name);

    List<SimpleQueryMethod> findByNameAndJobAllIgnoreCase(String name,String jobs);

    List<SimpleQueryMethod> findByNameContaining(String name);

    List<SimpleQueryMethod> findByNameNotContaining(String name);


}
