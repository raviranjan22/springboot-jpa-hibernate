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

------------------------------------------------------------
Inserting and Deleting Data using Spring JDBC (Fourth commit)
------------------------------------------------------------

1. Begin by emphasizing the simplicity of executing queries using Spring JDBC compared to traditional JDBC. Highlight the ease of code in Spring JDBC.

2. In order to insert details of a specific course, use a control/command to create a new class named "Course" in the "course" package under a specified package structure.

3. Design the "Course" class with private fields (ID, name, author) and corresponding methods (constructor, getters, and toString).

4. Pass the course details to the CourseJdbcRepository for insertion. Ensure that the insert query is dynamic, with placeholders replaced by actual values from the Course class.

5. Demonstrate the insertion process using a new course instance. Explain the use of double quotes for string values in Java code.

6. Implement a method for deleting a specific course by its ID. Modify the query accordingly.

7. Utilize a command line runner to execute the delete operation on a specific course ID.

8. If an error is identified in the delete operation (e.g., using the wrong query), correct it and restart the application.

9. Conclude by showcasing the updated H2 database with the latest data, including the inserted courses and the successful deletion of a course.

----------------------------------------------
Querying Data using Spring JDBC (Fifth commit)
----------------------------------------------

As we move towards the final phase of our work with Spring JDBC, our primary goal is to extract data from the database, specifically utilizing a select query implemented in the CourseJdbcRepository.

To cater to the requirement for a precise select query based on an ID:

```sql
SELECT * FROM course WHERE id = ?
```

Going forward, a new method is introduced in the CourseJdbcRepository class to execute this select query by ID:

```java
public Course findById(long id) {
    // Utilizing queryForObject to execute the select query and expecting a single result
    return jdbcTemplate.queryForObject(
        "SELECT * FROM course WHERE id = ?",
        new BeanPropertyRowMapper<>(Course.class),
        id
    );
}
```

The significance of `BeanPropertyRowMapper` is highlighted in efficiently linking the result set from the database to the corresponding `Course` bean. This linkage is possible due to the exact match between column names in the table and those in the bean.

Acknowledging the importance of setters, it's noted that initially, only getters existed in the `Course` class. To rectify this, setters are generated using the IDE.

Following this, the process of testing the `findById` method in the command line runner is explained. Initially encountering empty printed values, the issue is identified as the absence of setters in the `Course` class. After generating setters and restarting the application, the course beans are successfully printed with all values populated.

---------------------------------------------------------
Getting Started with JPA and EntityManager (Sixth commit)
---------------------------------------------------------

This is an overview of the transition from Spring JDBC to Java Persistence API (JPA) for database operations. It emphasizes the simplicity of Spring JDBC's Java code but acknowledges the potential complexity of queries when dealing with multiple tables. JPA, in contrast, adopts a distinctive approach by directly associating Java entities with database tables.

The key steps involved in utilizing JPA are outlined:

1. **Entity Mapping:** The Java class representing the entity (e.g., Course) is annotated with `@Entity`. Fields within the entity are linked to corresponding database table columns using annotations like `@Id` for primary keys and `@Column` for other attributes, establishing a direct connection between the Java object and the database table.

2. **Repository Creation:** A repository class (e.g., `CourseJpaRepository`) is crafted to interact with the entity through JPA. The repository is annotated with `@Repository` or `@PersistenceContext`, and an `EntityManager` is employed to manage the entity.

3. **CRUD Operations:** The repository class encompasses methods for CRUD operations. Examples include an `insert` method using `entityManager.merge(course)`, a `findById` method using `entityManager.find`, and a `deleteById` method using `entityManager.remove`.

4. **Transaction Management:** JPA operations are encapsulated within a transaction, and the `@Transactional` annotation is applied to enable transaction support.

5. **Testing and Verification:** The process of testing JPA functionality is demonstrated by creating a `CourseJpaCommandLineRunner` class. The switch from Spring JDBC to the newly created JPA repository is facilitated, and SQL queries generated by JPA can be examined by configuring `spring.jpa.show-sql=true` in the application properties.

JPA simplifies database operations, offering a more straightforward approach compared to Spring JDBC, especially as the database's complexity increases. Ultimately, the successful transition from Spring JDBC to JPA for database operations is highlighted.
