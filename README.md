# Spring Data JDBC how to examples
collection of how to example to show how to implement specific UC

### Guides
The following project illustrate how to use some features concretely:

* [Spring Data JDBC documentation](https://docs.spring.io/spring-data/relational/reference/jdbc.html)

## package: it.spaghettisource.springdatajdbc.howto.idStrategy

the scope of this package is to show how to use the standard repository to interact with flat entity (no inner beans) and use it 
to show the different strategies applicable to generate an ID for the aggregate ROOT:

* show how to use the DB to automatically generate the entity's id
* show how create manually the entity's id by the application for NEW entity instead that rely on the DB's ID auto generated
* show how determine by the application if execute and INSERT or an UPDATE and the manage manually the ID

this example analyze in details same aspects of the 
[ID Generation](https://docs.spring.io/spring-data/relational/reference/jdbc/entity-persistence.html#entity-persistence.id-generation)
that are analyzed more in details in the section of the official documentation 
[Entity State Detection Strategies](https://docs.spring.io/spring-data/relational/reference/repositories/core-concepts.html#is-new-state-detection)


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