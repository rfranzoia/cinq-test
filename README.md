# CINQ-Test

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
