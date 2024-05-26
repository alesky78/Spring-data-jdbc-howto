package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface QueryByMethodRepository extends ListCrudRepository<QueryByMethod,Long> {

    Optional<QueryByMethod> findByName(String name);

    List<QueryByMethod> findByAgeGreaterThan(int age) ;

    List<QueryByMethod> findByAgeBetween(int from, int to);

    List<QueryByMethod> findByBirthDateAfter(LocalDate date);

    List<QueryByMethod> findByJobIn(Collection<String> jobs);

    List<QueryByMethod> findByNameNot(String name);

    List<QueryByMethod> findByNameIgnoreCase(String name);

    List<QueryByMethod> findByNameAndJobAllIgnoreCase(String name, String jobs);

    List<QueryByMethod> findByNameContaining(String name);

    List<QueryByMethod> findByNameNotContaining(String name);

    List<QueryByMethod> findAllByOrderByAgeDesc();

    List<QueryByMethod> findAllByOrderByAgeDescNameAsc();



}
