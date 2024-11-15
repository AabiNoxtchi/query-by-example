# Getting Started

### Query By Example ###  

Spring Data JPA QueryByExample(QBE) allows to construct queries based on the attributes of an example entity instance.  
The methods to query db by Example are provided in repository interface QueryByExampleExecutor, which is extended by
JpaRepository. the methods include findAll(Example example) which is overloaded with Pageable and Sort, and more.

The System exposes one search endpoint, therefore InitialData class, a CommandLineRunner implementation initiates test data.
StudentRepositoryTest class demonstrates more search options. 

Query by Example is well suited for several use cases:  
Querying data store with a set of static or dynamic constraints.  
Frequent refactoring of the domain objects without worrying about breaking existing queries.  
Working independently of the underlying data store API.  
  
Query by Example also has several limitations:  
No support for nested or grouped property constraints, such as firstname = ?0 or (firstname = ?1 and lastname = ?2).  
Store-specific support on string matching. Depending on the databases, String matching can support starts/contains/ends/regex for strings.  
Exact matching for other property types. such as (age >= ?0 and age <= ?1).
<br><br>  


### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.5/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.5/gradle-plugin/packaging-oci-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.3.5/reference/web/servlet.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.3.5/reference/data/sql.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

