# Spring Data JDBC how to examples
collection of how to example to show how to implement specific UC. 
Based on Spring 3.3.0

### Guides
The following project illustrate how to use some features concretely, 
where possible the link of the official documentation is referenced: [Spring Data JDBC documentation](https://docs.spring.io/spring-data/relational/reference/jdbc.html).
Moreover Spring Data JDBC expose a set of [examples](https://github.com/spring-projects/spring-data-examples/tree/main/jdbc) that can be analyzed

## package: it.spaghettisource.springdatajdbc.howto.idStrategy
the scope of this package is to show how to use the standard repository to interact with flat entity (no inner beans) and use it 
to show the different strategies applicable to manage the ID for the aggregate ROOT and show the Entity State Detection Strategies:

* how to use the DB to automatically generate the entity's id
* how to create manually the entity's id by the application for NEW entity instead that rely on the DB's ID auto generated
* how to determine by the application if execute and INSERT or an UPDATE and the manage manually the ID
* how the versioning drive the INSERT or an UPDATE of an entity

this example analyze the main aspects described in the official documentation
* [ID Generation](https://docs.spring.io/spring-data/relational/reference/jdbc/entity-persistence.html#entity-persistence.id-generation) 
* [Entity State Detection Strategies](https://docs.spring.io/spring-data/relational/reference/repositories/core-concepts.html#is-new-state-detection)

The detection strategy defined in the documentation"Providing a custom EntityInformation implementation" is not analyzed in this examples

this test don't analyze ID strategy related to References to other entities, see the official documentation section
[Supported Types in Your Entity](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html#jdbc.entity-persistence.types)
with particular attention to the second related to "References to other entities" for the 1 to 1 and the Set, Map and List used for the 1 to M 

### test: SimpleCrudAutoIdTest

a simple case that show how to create a flat entity and create the related repository.
The interaction with the repository is based on the default method automatically generated.
In this example the ID of the entity are generated automatically by the DB 


### test: SimpleCrudTestsManualIdByCallBackTest

this example show how generate the ID of the entity by application code for the NEW entity. 
It uses the BeforeConvertCallback to generate the ID.  
By this solution it is still Spring that is responsible to determine if execute INSERT or UPDATE


### test: SimpleCrudTestsManualIdByPersistableInterfaceTest

Using the Persistable interface we leverage Spring-Data from the responsibility to determine if execute INSERT or UPDATE
Then we can set manually the ID of the entity and force Spring Data to do an INSERT instead that an UPDATE

Important Note to remember: Properties of Persistable will get detected and persisted if you use AccessType.PROPERTY. To avoid that, use @Transient.



### test: SimpleCrudVersionedTest

Despite the @Version annotation it is not used strictly related to the ID generation, if effect the behaviour of Spring-Data. 
In fact when an Entity has a field annotated wit @Version, 
Spring determine if execute INSERT or UPDATE not more over an ID but it is driven by the Version attribute,
This example has the scope to make it in practise and show the behaviour under this condition. 
To keep the test simple, it used the ID autogenerated.

Important Note to remember: Is it possible exploit all the power of Spring combining strategy's together, 
for example using the @Version annotation and implementing Persistable in the way to drive when to make INSERT or UPDATE


## package: it.spaghettisource.springdatajdbc.howto.createRepository

the scope of this package is to show how to use the feature exposed by Spring Data to create, 
use and extend the functionality of the repository

* how to use the paging and sorting
* how to customize a repository extending its functionality

this example analyze the main aspects described in the official documentation
* [Defining Repository Interfaces](https://docs.spring.io/spring-data/relational/reference/repositories/definition.html)
* [Creating Repository Instances](https://docs.spring.io/spring-data/relational/reference/repositories/create-instances.html) 
* [Paging, Iterating Large Results, Sorting & Limiting](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.special-parameters)
* [Custom Repository Implementations](https://docs.spring.io/spring-data/relational/reference/repositories/custom-implementations.html)

This package doesn't do example for this topics, that are more related to configuration of the application:
* [Using Repositories with Multiple Spring Data Modules](https://docs.spring.io/spring-data/relational/reference/repositories/definition.html#repositories.multiple-modules)
* [Using filter](https://docs.spring.io/spring-data/relational/reference/repositories/create-instances.html#repositories.using-filters)
* [Standalone Usage](https://docs.spring.io/spring-data/relational/reference/repositories/create-instances.html#repositories.using-filters)
* [usage of @RepositoryDefinition and @NoRepositoryBea annotation](https://docs.spring.io/spring-data/relational/reference/repositories/create-instances.html#repositories.using-filters)


### test: PageableAndSortableTest

a simple test that explore the functionality of paging and sorting exposed by the interface ListPagingAndSortingRepository
or by the Query Methods of the CrudRepository.

Important Note to remember: 
* [Which return types is more Appropriate: List Vs Slice Vs Page Vs ....](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.scrolling.guidance)
* APIs taking Sort, Pageable and Limit expect non-null values to be handed into methods. 
If you do not want to apply any sorting or pagination, use Sort.unsorted(), Pageable.unpaged() and Limit.unlimited().
* A Page knows about the total number of elements and pages available. It does so by the infrastructure triggering a count query to calculate the overall number. As this might be expensive (depending on the store used), you can instead return a Slice. A Slice knows only about whether a next Slice is available, which might be sufficient when walking through a larger result set


### test: CustomRepositoryTest

This test show the capacity of Spring Data to Extend a Repository using the fragment interfaces.
In this example we use the extension of the repository to create a generic Insert method that at low level use the 
[JdbcAggregateTemplate](https://docs.spring.io/spring-data/jdbc/docs/current/api/org/springframework/data/jdbc/core/JdbcAggregateTemplate.html), 
This permit to control the behaviour of the repository forcing INSERT or UPDATE and skip the Entity State Detection Strategies logic exposed by Spring Data JBDC.

Important Note to remember: The implementation of the JdbcAggregateTemplate in case of an INSERT if the Aggregate support the 
@Version annotation set automatically the value 0 interdependently by the value that you set in the code, this can be show simply modify 
this aggregate and add to it the @Version property.



## package: it.spaghettisource.springdatajdbc.howto.defineQueryMethod

the scope of this package is to show how to define and user Query Method on the spring Repository

* how to define a query by a method name  
* how to define manually by annotation
  
this example analyze the main aspects described in the official documentation
* [Spring data](https://docs.spring.io/spring-data/commons/reference/repositories/query-methods-details.html)
* [Spring data jbdc](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html)
* [Spring data jbdc - specific implemnetation for jdbc](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html)

The [Query Lookup Strategies](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.query-methods.query-lookup-strategies) 
that spring data jdbc used rely on [CREATE_IF_NOT_FOUND](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html#jdbc.query-methods.strategies).
This can be overwritten defining the queryLookupStrategy attribute of the EnableJdbcRepositories annotation



This package doesn't cover this topics

* [Paging, Iterating Large Results, Sorting & Limiting](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.special-parameters) becouse already analyzed in the test: PageableAndSortableTest

### test: QueryByMethodTest

a simple test that explore the functionality of creating query automatically by methods names.
This test explore just the query method on the root aggregate, see the test PropertyExpressionsTest for embedded or nested beans

the full set of key work can be found here
* [Repository query keywords](https://docs.spring.io/spring-data/relational/reference/repositories/query-keywords-reference.html)
* [Repository query return types supportted by spring data jdbc - table 1](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html#jdbc.query-methods.strategies)
* [Repository query return types](https://docs.spring.io/spring-data/relational/reference/repositories/query-return-types-reference.html)

Important Note to remember:
* Spring try to honor the return type of the method but in case it is not possible, it return an exception like IncorrectResultSizeDataAccessException


### test: PropertyExpressionsTest

a simple test that show how to make query by methods names traversing nested properties for nested been and embedded bean in the aggregate root.
* spring Data Jdbc doesn't support the property expression for the nested properties, we use instead @Query to go over this limitation. This test prove this problem
* spring Data Jdbc support the property expression for the @Embedded bean properties. 

official documentation of the [Property Expressions](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.query-methods.query-property-expressions)

Important Note to remember:

* Spring Data Jdbc doesn't support [nested property using query by method names (ticket #1227 open)](https://github.com/spring-projects/spring-data-relational/issues/1227) 
  :for example one nested bean  ( mapped by 1 to 1 for with is own table). 
  If a method that use this technics is implemented  Spring Data will throw java.lang.IllegalArgumentException: Cannot query by nested property at application start-up,
* underscores (_) is a reserved character, Spring strongly advise to follow standard Java naming conventions, see the official documentation to see the possible name conflict and how to avoid it  


### test: QueryByAnnotationTest

This test that explore the functionality of creating query by @Query annotation. This test use a complex aggregation root composed by
* simple properties on the aggregation root
* one the embedded bean (1 to 1)
* one nested bean (1 to 1)
* one nested bean (1 to M)

If you want to write an appropriate SQL in the @Query annotation is mandatory to understand how the mapping of Spring Data works: 
Spring Data Jdbc expected that the name of the columns returned in the select clausole of the statement are named respecting 
the convention or it will be not able to map it back correctly.
The [mapping](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html) convention in the documentation 
doesn't cover everything but is a good point where to start: the section [Convention-based Mapping](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html#mapping.conventions)
and [Naming Strategy](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html#mapping.conventions) are important in this context.

a simple way to write automatically the structure of the SQL query that you should add in the @Query annotation, is to write a test and run the standard findAll() on the repository, if you have the sql logging enable
Spring Data JDBC will write the complete query in the log, now you can take it and modify

Behaviour of Spring Data Jdbc: 
* if you have a aggregate root (with its repository) that has a 1 to 1 relationship, to build back the object automatically 
  Spring Data JDBC expected that the the sql in the @Query obtain the result in a unique query:
  you have to write (probably) a join and the select clausole must contain the field al the aggregate root and the bean in the 1 to 1 relationship
* if you have a aggregate root (with its repository) that has a 1 to M relationship, Spring Data JDBC execute first a unique query on the 
  aggregate root and all the 1 to 1 bean in relationship using join, then execute a new query for each 1 to M relationship. This can be exploited: 
  you can write a @Query that consider only the aggregate root and the 1 to 1 relationship then spring will run automatically the query on the  1 to M relationship
  completing automatically the return mapping
* the name convention for the alias to define in the select clausole for the @Embedded bean is the same of the aggregate root, example:
  an aggregate Root with an @Embedded Book book{ String author} become --> SELECT Root.author AS author from FROM Root
* the name convention for the alias to define in the select clausole for the 1 to 1 relationship is "name property in the agregate root"_"name property in the bean", example:
  an aggregate Root with an 1 to 1 Book book{ String author} become --> SELECT book.author AS book_author from FROM Root LEFT OUTER JOIN Book book  
 





