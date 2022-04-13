#### Steps To Test Application
* unzip application
* Open it in An IDE
* in Src/main/resources/application.properties, are the configuration to dataBase:
* >> For H2 database you can create a new Database or lets like so.

* run the application, Spring Boot will generate a name of database Hashed, -1-You copied.
* in the browser tap localhost:8888/h2-console/
* the page will show the memory interface DB
* in the input of JDBC URL : past what you copied before.
* not modify any thang else.
* click on Connect
* #### Test Api with Swagger
* On Browser tap : http://localhost:8888/swagger-ui/index.html
* you will get all rest methode that you define in the controller

  >> For PostgresDB spring.datasource.url=jdbc:postgresql://localhost:5432/test_db

################################
#here the configuration that you should copy and passed in application.properties in the place of
#memory database.
#you should have PostgreSql installed in your Laptop
###############################
# Set here configurations for the database connection

spring.datasource.url=jdbc:postgresql://localhost:5432/test_db
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
# Show or not log for each sql query
spring.jpa.show-sql=true
# Hibernate ddl auto (create, create-drop, update): with "create-drop" the database
# schema will be automatically created afresh for every start of application
spring.jpa.hibernate.ddl-auto=create-drop
# Allows Hibernate to generate SQL optimized for a particular DBMS
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect





