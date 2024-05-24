# Spring Data JDBC how to examples
collection of how to example to show how to implement specific UC

### Guides
The following project illustrate how to use some features concretely:

* [Spring Data JDBC documentation](https://docs.spring.io/spring-data/relational/reference/jdbc.html)

## package: it.spaghettisource.springdatajdbc.howto.simplecrud

the scope of this package is to show how to use the standard repository to interact with flat entity (no inner beans).
Moreover, show the different strategies applicable to generate an ID for the aggregate ROOT:
* create a simple crud
* show how to use the DB to automatically generate the entity's id
* show how create manually the entity's id by the application for new entity instead that rely of the DB's ID auto generated

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
By this solution it is still Spring that is responsible to determine if execute and INSERT and an UPDATE 
