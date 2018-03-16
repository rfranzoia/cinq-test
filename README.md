# CINQ-Test

# Project coverage(3)

- changed some configuration files to create the tables on the memory H2 DB
   + the tables are still not being populated, despite the use of a scrito to do so
   + changed the JUnit tests to make it possible to build the JAR

# Project coverage(2)

- Added data populate REST service. Passing a List of Cities or Countries (respectively) to the service http://localhost:8090/rest/cities/populate or http://localhost:8090/rest/countries/populate
   + the list must be passed as a JSON list
   + the IDs may be ommited

- still didn't fix the JUnit tests for City and Country repository. The memory DB is being created but the tables are not available. Still looking for a solution
   + dev note: in my research I found that no one uses profile files for database configuration, but I don't believe this is the problem at all

- There is a method for loading data from CSV files, but it's not being used

# Project coverage

- The project is using Java 8, but since its' code is very simple at the moment only one class is using something really "visible"
- RESTFull service is implemented
- Data Manipulation layer is implemented using Spring-Data + Hibernate
- Spring-boot was upgraded to 2.0.0, also all dependencies (including JPA and Spring-data) have been updated
- The project uses Maven

- I'm using MySQL implementation, but not the actual generation of the schema and data population (is that a problem??), so I runned the script on a MySQL server I have here
- To run the application only the command mvn spring-boot:run is working
   + The current version has errors during the JUnit tests, and running mvn clean package doesn't complete properly, I'm working on this
   + The Respository Tests are the ones showing error
   + The EndPoint test works just fine
- All proposed exercices have been implemented so far, but one.
   + still working on the data load (spent too much time searching for a solution on my JUnit problem)
- changed a few names and paths but the final name will be as specified once the package is complete
