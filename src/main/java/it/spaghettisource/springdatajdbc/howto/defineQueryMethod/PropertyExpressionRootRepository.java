package it.spaghettisource.springdatajdbc.howto.defineQueryMethod;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyExpressionRootRepository extends ListCrudRepository<PropertyExpressionsRoot,Long> {

    List<PropertyExpressionsRoot> findAllByName(String address);

    /**
     * Spring Data Jdbc doesn't support nested properties for nested bean mapped in another table
     *  if this method is de-commented, will throw java.lang.IllegalArgumentException: Cannot query by nested property: nested.address
     *  at application start-up, use @Query for this cases instead, the next method show exactly how to do it
     */
//    List<PropertyExpressionsRoot> findAllByNested_Address(String address);


    @Query("SELECT PROPERTY_EXPRESSIONS_ROOT.ID AS ID, PROPERTY_EXPRESSIONS_ROOT.NAME AS NAME, nested.ID AS NESTED_ID, nested.ADDRESS AS NESTED_ADDRESS FROM PROPERTY_EXPRESSIONS_ROOT " +
            "LEFT OUTER JOIN PROPERTY_EXPRESSIONS_NESTED nested ON nested.PROPERTY_EXPRESSIONS_ROOT = PROPERTY_EXPRESSIONS_ROOT.ID " +
            "WHERE nested.ADDRESS = :address")
    List<PropertyExpressionsRoot> findAllByNested_AddressWithQueryAnnotation(@Param("address") String address);

}

