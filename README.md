------
Agenda
------

- Introduction to JPA and Hibernate in a Modern Spring Boot context.
- Emphasis on hands-on learning.
- Sequential approach: Pre-JPA understanding, discussing JDBC and Spring JDBC.
- Exploration of why JPA and Hibernate, highlighting differences.
- Simplification with Spring Boot for JPA and Spring Boot Data JPA.
- Creation of Spring Boot Project using H2 in-memory database.
- Establishment of a COURSE table in H2.
- Initial usage of Spring JDBC for data interaction.
- Progression to JPA and Hibernate for similar operations, understanding differences.
- Section concludes with the application of Spring Data JPA.
- Step-by-step learning of JPA, Hibernate, and Spring Data JPA.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Creating a Spring Boot project, configuring dependencies, importing it into Eclipse, and launching the application while emphasizing the simplicity and automation provided by Spring Boot (First commit)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

1. **Creating a Spring Boot Project:**
   - Use the Spring Initializr at start.spring.io to create a Spring Boot project.
   - Choose Maven as the build tool, Java as the language, and Spring Boot version 3.3.0.M1.
   - Set project metadata with group ID as "com.ranjan.springboot" and artifact ID as "learn-jpa-and-hibernate."
   - Ensure using at least Java 17, as Spring Boot 3 requires it.

2. **Configuring Dependencies:**
   - Add dependencies for Spring Web, Spring Data JDBC, Spring Data JPA, and H2 Database.
   - Spring Web for building a simple web application.
   - Spring Data JDBC and JPA for data persistence.
   - H2 Database for an in-memory database.

3. **Generating and Importing Project:**
   - Click on "Generate" to download a zip file of the project.
   - Unzip the file and import the project into Eclipse using Maven import.
   - Configure Eclipse workspace and import the project with the specified group and artifact ID.

4. **Launching the Application:**
   - Run the Java application (LearnJpaAndHibernateApplication.java) to launch the Spring Boot application in Eclipse.
   - Observe console logs indicating JDBC and JPA initialization, hibernate configuration, and Tomcat launching on port 8080.

5. **Understanding the Magic:**
   - Acknowledge the background processes and "magic" happening during application startup.
   - Highlight the ease of project creation, dependency management, and application launch provided by Spring Boot.
   
   
---------------------------------------------------------------------------------------------------------------------------------------------------
The process of setting up a Spring project with an H2 database, configuring connections, and creating a table using Spring Data JPA (Second commit)
---------------------------------------------------------------------------------------------------------------------------------------------------

1. **Project Creation and H2 Database:**
   - Used Spring Initializr to create a project.
   - Utilized H2 database, an in-memory database.

2. **Connecting to H2 Database:**
   - Access the H2 console by configuring `spring.h2.console.enabled` property in `application.properties`.
   - Accessible on localhost:8080/h2-console
   - Dynamic URL generated initially; recommended to configure a static URL for ease.

3. **Configuring Static URL:**
   - Set `spring.datasource.url` in `application.properties` to a static URL.
   - Restart the application to use the configured URL for H2 console access.

4. **Creating Table in H2:**
   - To use JPA and Spring Data JPA, a table needs to be created in H2.
   - Configured the table in `schema.sql` with columns: ID (bigint), NAME (varchar), AUTHOR (varchar), and a primary key on ID.

5. **Spring Data JPA Integration:**
   - Spring Data JPA Starter automatically picks up `schema.sql` to create the table in H2.
   - After starting the application, verified the creation of the 'course' table in H2 console.

6. **Final Steps:**
   - Highlighted the importance of having the correct file (`schema.sql`) in the right folder (`src/main/resources`).
   - Mentioned that future steps would involve using Spring JDBC, JPA, and Spring Data JPA.

-----------------------------------------------------------------------------------------
Focus on Spring JDBC for inserting and deleting data in the "Course" table (Third commit)
-----------------------------------------------------------------------------------------

1. **Overview of JDBC and Spring JDBC:**
   - JDBC: Java Database Connectivity.
   - Spring JDBC: Simplifies database access using JDBC, reducing Java code.
   
2. **Data Manipulation in H2 Console:**
   - Demonstrated data manipulation in the "Course" table using SQL queries.
   - Inserted data using `INSERT` query.
   - Selected data using `SELECT` query.
   - Deleted data using `DELETE` query.
   
3. **Sequel Query Language:**
   - Described the use of SQL in JDBC and Spring JDBC.
   - Emphasized the need for writing SQL queries in both cases.
   
4. **Comparison between JDBC and Spring JDBC:**
   - Showcased examples with JDBC and Spring JDBC.
   - Highlighted the difference in code volume.
     - JDBC: Requires more Java code.
     - Spring JDBC: Requires significantly less Java code.

5. **Spring JDBC Exercise:**
   - Discussed the plan to execute a query using Spring JDBC.
   - Noted the importance of saving queries, given H2 Console data refresh.

6. **Code Comparison:**
   - Illustrated a comparison between JDBC and Spring JDBC code for the same query.
   - Emphasized the reduced code complexity in Spring JDBC.

7. **Reminder for H2 Console Data:**
   - Mentioned the automatic refresh of H2 Console data on server restart.
   - Advised saving queries in a text file for reference.

8. **Next Step:**
   - Stated the intention to execute a query with Spring JDBC as the next exercise.
   - Highlighted the goal of writing minimal Java code with Spring JDBC.
   
   
We will learn the process of executing a query using Spring JDBC in a Java application. The steps involve creating a new class called "CourseJdbcRepository" in the ".course.jdbc" package, marked with the @Repository annotation. The class uses the JdbcTemplate from the org.springframework.jdbc.core package to interact with the database.

Now introduce a method named "insert" in the CourseJdbcRepository class, where we will demonstrate using the update method of the JdbcTemplate to execute an SQL insert query. We will use text blocks (""" """) in Java to maintain the formatting of the SQL query for better readability.

We will also introduce the concept of a Command Line Runner in Spring Boot, specifically the CommandLineRunner interface, which allows the execution of custom logic at the startup of the application. We will then create a new class called "CourseJdbcCommandLineRunner" that implements CommandLineRunner, and demonstrate how to use it to execute the insert query at the application startup by autowiring the CourseJdbcRepository and calling the insert method.

Finally, we will check the database to verify that the data has been successfully inserted.
