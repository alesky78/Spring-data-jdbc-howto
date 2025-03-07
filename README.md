# Spring Data JDBC how to examples

collection of how to example to show how to implement specific UC.
Based on Spring 3.3.0

### Guides

The following project illustrate how to use some features concretely,
where possible the link of the official documentation is
referenced: [Spring Data JDBC documentation](https://docs.spring.io/spring-data/relational/reference/jdbc.html).
Moreover Spring Data JDBC expose a set
of [examples](https://github.com/spring-projects/spring-data-examples/tree/main/jdbc) that can be analyzed

## package: it.spaghettisource.springdatajdbc.howto.idStrategy

the scope of this package is to show how to use the standard repository to interact with flat entity (no inner beans)
and use it
to show the different strategies applicable to manage the ID for the aggregate ROOT and show the Entity State Detection
Strategies:

* how to use the DB to automatically generate the entity's id
* how to create manually the entity's id by the application for NEW entity instead that rely on the DB's ID auto
  generated
* how to determine by the application if execute and INSERT or an UPDATE and the manage manually the ID
* how the versioning drive the INSERT or an UPDATE of an entity

this example analyze the main aspects described in the official documentation

* [ID Generation](https://docs.spring.io/spring-data/relational/reference/jdbc/entity-persistence.html#entity-persistence.id-generation)
* [Entity State Detection Strategies](https://docs.spring.io/spring-data/relational/reference/repositories/core-concepts.html#is-new-state-detection)

The detection strategy defined in the documentation"Providing a custom EntityInformation implementation" is not analyzed
in this examples

this test don't analyze ID strategy related to References to other entities, see the official documentation section
[Supported Types in Your Entity](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html#jdbc.entity-persistence.types)
with particular attention to the second related to "References to other entities" for the 1 to 1 and the Set, Map and
List used for the 1 to M

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

Important Note to remember: Properties of Persistable will get detected and persisted if you use AccessType.PROPERTY. To
avoid that, use @Transient.

### test: SimpleCrudVersionedTest

Despite the @Version annotation it is not used strictly related to the ID generation, if effect the behaviour of
Spring-Data.
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

This package doesn't do example for this topic, that are more related to the configuration of the application:

* [Using Repositories with Multiple Spring Data Modules](https://docs.spring.io/spring-data/relational/reference/repositories/definition.html#repositories.multiple-modules)
* [Using filter](https://docs.spring.io/spring-data/relational/reference/repositories/create-instances.html#repositories.using-filters)
* [Standalone Usage](https://docs.spring.io/spring-data/relational/reference/repositories/create-instances.html#repositories.using-filters)
* [usage of @RepositoryDefinition and @NoRepositoryBea annotation](https://docs.spring.io/spring-data/relational/reference/repositories/create-instances.html#repositories.using-filters)

### test: PageableAndSortableTest

a simple test that explore the functionality of paging and sorting exposed by the interface
ListPagingAndSortingRepository
or by the Query Methods of the CrudRepository.

Important Note to remember:

* [Which return types is more Appropriate: List Vs Slice Vs Page Vs ....](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.scrolling.guidance)
* APIs taking Sort, Pageable and Limit expect non-null values to be handed into methods.
  If you do not want to apply any sorting or pagination, use Sort.unsorted(), Pageable.unpaged() and Limit.unlimited().
* A Page knows about the total number of elements and pages available. It does so by the infrastructure triggering a
  count query to calculate the overall number. As this might be expensive (depending on the store used), you can instead
  return a Slice. A Slice knows only about whether a next Slice is available, which might be sufficient when walking
  through a larger result set

### test: CustomRepositoryTest

This test show the capacity of Spring Data to Extend a Repository using the fragment interfaces.
In this example we use the extension of the repository to create a generic Insert and update method that at low level use the
[JdbcAggregateTemplate](https://docs.spring.io/spring-data/jdbc/docs/current/api/org/springframework/data/jdbc/core/JdbcAggregateTemplate.html),
This permit to control the behaviour of the repository forcing INSERT or UPDATE and skip the Entity State Detection
Strategies logic exposed by Spring Data JBDC.

Important Note to remember: The implementation of the JdbcAggregateTemplate in case of an INSERT if the Aggregate
support the
@Version annotation set automatically the value 0 interdependently by the value that you set in the bean.
If you want to simulate it:
modify the aggregate root adding to it a @Version property, add the version column in the CUSTOM table and write a test
method.

## package: it.spaghettisource.springdatajdbc.howto.defineQueryMethod

the scope of this package is to show how to define and use Query Method on the spring Repository to:

* select aggregate by method name
* select aggregate writing manually SQL by @Query annotation
* insert or update writing manually SQL by conjunction of @Query and @Modifying annotation and all the consequences of
  this choose

this example analyze the main aspects described in the official documentation

* [Spring data](https://docs.spring.io/spring-data/commons/reference/repositories/query-methods-details.html)
* [Spring data jbdc](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html)
* [Spring data jbdc - specific implemnetation for jdbc](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html)

The [Query Lookup Strategies](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.query-methods.query-lookup-strategies)
that spring data jdbc used rely
on [CREATE_IF_NOT_FOUND](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html#jdbc.query-methods.strategies).
This can be overwritten defining the queryLookupStrategy attribute of the EnableJdbcRepositories annotation

The [Named Query in the @query ](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html#jdbc.query-methods.named-query)
could be store in a file instead that in the @Query annotation itself

This package doesn't cover this topics

* [Paging, Iterating Large Results, Sorting & Limiting](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.special-parameters)
  becouse already analyzed in the test: PageableAndSortableTest

### test: QueryByMethodTest

a simple test that explore the functionality of creating query automatically by methods names.
This test explore just the query method on the root aggregate, see the test PropertyExpressionsTest for embedded or
nested beans

the full set of key work can be found here

* [Repository query keywords](https://docs.spring.io/spring-data/relational/reference/repositories/query-keywords-reference.html)
* [Repository query return types supportted by spring data jdbc - table 1](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html#jdbc.query-methods.strategies)
* [Repository query return types](https://docs.spring.io/spring-data/relational/reference/repositories/query-return-types-reference.html)

Important Note to remember:

* Spring try to honor the return type of the method but in case it is not possible, it return an exception like
  IncorrectResultSizeDataAccessException

### test: PropertyExpressionsTest

a simple test that show how to make query by methods names traversing nested properties for nested been and embedded
bean in the aggregate root.

* spring Data Jdbc doesn't support the property expression for the nested properties, we use instead @Query to go over
  this limitation. This test prove this problem
* spring Data Jdbc support the property expression for the @Embedded bean properties.

official documentation of
the [Property Expressions](https://docs.spring.io/spring-data/relational/reference/repositories/query-methods-details.html#repositories.query-methods.query-property-expressions)

Important Note to remember:

* Spring Data Jdbc doesn't
  support [nested property using query by method names (ticket #1227 open)](https://github.com/spring-projects/spring-data-relational/issues/1227)
  :for example one nested bean  ( mapped by 1 to 1 for with is own table).
  If a method that use this technics is implemented Spring Data will throw java.lang.IllegalArgumentException: Cannot
  query by nested property at application start-up,
* underscores (_) is a reserved character, Spring strongly advise to follow standard Java naming conventions, see the
  official documentation to see the possible name conflict and how to avoid it

### test: QueryByAnnotationTest

This test that explore the functionality of creating query by @Query annotation. This test use a complex aggregation
root composed by

* simple properties on the aggregation root
* one the embedded bean (1 to 1)
* one nested bean (1 to 1)
* one nested bean (1 to M)

If you want to write an appropriate SQL query in the @Query annotation, it is mandatory to understand how the mapping in
Spring Data works.
Spring Data JDBC expects that the names of the columns returned in the select clause of the statement follow the naming
convention;
otherwise, it will not be able to map them correctly.
The [mapping](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html) convention in the documentation
doesn't cover everything but is a good point where to start: the
section [Convention-based Mapping](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html#mapping.conventions)
and [Naming Strategy](https://docs.spring.io/spring-data/relational/reference/jdbc/mapping.html#mapping.conventions) are
important in this context.

The simplest way to automatically write the skeleton structure of the SQL query that you can add in the @Query
annotation is to write a test and run the standard findAll() or findById() methods on the repository.
If you have SQL logging enabled, Spring Data JDBC will log the complete query. You can then take this logged query and
modify it to write your custom query.

Behaviour of Spring Data Jdbc:

* If you have an aggregate root (with its repository) that has a 1-to-1 relationship, to automatically reconstruct the
  object,
  Spring Data JDBC expects that the SQL in the @Query obtains the result in a single query:
  you need to write (probably) a join, and the select part of the SQL must contain the fields of both the aggregate root
  and the bean in the 1-to-1 relationship.).
* If you have an aggregate root (with its repository) that has a 1-to-M relationship, Spring Data JDBC first executes a
  single query on the aggregate root and all the 1-to-1 beans in the relationship using joins,
  then executes a new query for the 1-to-M relationship (the 1+N problem). This behavior can be exploited: if your
  method return the same type of the repository you can write a @Query that considers only the aggregate root
  and all the other the 1-to-1 relationships, and Spring will automatically run the queries for the 1-to-M
  relationships, completing the return mapping automatically.
* The naming convention for the aliases to define in the select part of the SQL for the @Embedded bean is the same as
  for the aggregate root.
  For example, an aggregate root with an @Embedded Book book containing String author becomes SELECT Root.author AS
  author FROM Root.
* The naming convention for the aliases to define in the select part of the SQL for the 1-to-1 relationship is "name of
  the property in the aggregate root"_"name of the property in the bean".
  For example, an aggregate root with a 1-to-1 Book book containing String author becomes SELECT book.author AS
  book_author FROM Root LEFT OUTER JOIN Book book.

### test: ModifyByQueryAnnotationTest

This test show hot to use the conjunction of @Query and @Modifying annotation to write writing manually SQL INSERT or
UPDATE statement.
This functionality is described also in
the [official documentation](https://docs.spring.io/spring-data/relational/reference/jdbc/query-methods.html#jdbc.query-methods.at-query.modifying)

Before to start to use this feature is important to understand that using @Modifying has some important drawbacks

* Modifying queries are executed directly against the database. No events or callbacks get called.
  Therefore also fields with auditing annotations do not get updated if they don’t get updated in the annotated query
* @Version is not managed by this query then this must be implemented manually in the SQL query: VERSION = VERSION +1
  WHERE ID = :id
* Also if the is managed directly in the SQL (VERSION = VERSION +1 WHERE ID = :id) Spring doesn't throw
  OptimisticLockingFailureException()
  in case of a missing update, it is responsibility of the developer find a solution to throw the
  OptimisticLockingFailureException if expected

## package: it.spaghettisource.springdatajdbc.howto.nPlus1

the scope of this package is to show how to approach the N+1 problem in Spring Data JDBC.

Virtually Spring Data JDBC loads complete aggregates in one go. But if you looked at what SQL actually gets run, for
not-flat aggregates (involve 1-to-M) multiple SQL statements get run.
This is the N+1 problem. For example: having an aggregate with a single collection of N elements, to load N aggregates,
N+1 queries get executed (one for the root and N for the child entities).

Several strategies are possible to solve this problem:

* you may do a join and then parse the response to your specific object.
* Spring Data JDBC (since 3.2) framework expose
  the [Single Query Loading](https://docs.spring.io/spring-data/relational/reference/jdbc/entity-persistence.html#jdbc.loading-aggregates)
  functionality
  but at this stage this is experimental functionality and cover limited cases. the detail of the implemented solution
  can be found in
  this [article of the official spring blog](https://spring.io/blog/2023/08/31/this-is-the-beginning-of-the-end-of-the-n-1-problem-introducing-single-query)

the scope of this package is to show how to solve this problem.

### test: SingleCollectionTest

Spring Data JDBC permit at low level to extend the default behaviour of the repository.
This test show exactly this, how to solve the problem with a programmatic manual approach.

the solution proposed are:

* prepare a @Query annotation with a join over all the tables and configure a custom ResultSetExtractor
* extend the repository and use JdbcAggregateTemplate to write again custom query that solve the N+1 problem, in this
  case the solution is exactly the same as before
  but we show how we can do it using the NamedParameterJdbcTemplate instead that in a custom @Query annotation
* extend the repository like in the previous case, but use directly the jdbc spring utility: JdbcTemplate
* extend the repository like in the previous case, but use directly the jdbc spring utility: jdbcClient the new utility of Spring to implement fluent API 
