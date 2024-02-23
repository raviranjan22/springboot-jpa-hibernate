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

Throughout the transition from Spring JDBC to JPA, there has been a notable shift from extensive SQL queries and Java code to a more streamlined approach. Initially, with Spring JDBC, the process involved crafting numerous queries and Java code. However, the burden was somewhat alleviated as Spring JDBC allowed a greater focus on SQL queries and reduced the demand for extensive Java code.

With the adoption of JPA, there has been a significant leap forward by eliminating the need to worry about queries altogether. Instead, the emphasis is on mapping entities to tables. In our case, the "course" entity was mapped to the corresponding table in the database, facilitating straightforward data insertion using JPA. The entity manager plays a crucial role in managing entities, simplifying operations such as insertion, finding, and removal. This approach liberates us from the complexities of directly dealing with SQL queries.

Despite the apparent simplicity in the code, it's crucial to recognize that beneath the surface, SQL queries are still executed. JPA operates in the background, translating high-level operations into the necessary SQL queries. This became evident as we reviewed the queries executed during various operations like insert, delete, and find by ID.

Upon delving into the JPA code, it became apparent that the entity manager takes charge of handling these queries. For example, during the insert operation, the entity manager verifies the absence of a row with a specific ID before proceeding with the insertion. The delete operation involves an initial select query to locate the course with the specified ID before executing the delete query.

The advantage of JPA lies in the fact that, despite the presence of underlying SQL queries, we can concentrate solely on using the entity manager's methods for different operations. This results in code that is more straightforward and readable, contributing to increased productivity.

Now, as the journey progresses, a question arises: why consider Spring Data JPA when simplicity has already been achieved with JPA? The exploration of the need for Spring Data JPA will be the focus of our upcoming steps.

-----------------------------------------------------
Getting Started with Spring Data JPA (Seventh commit)
-----------------------------------------------------

The discussion delves into the progression of database access technologies within Java development. Initially starting with JDBC, developers are required to write extensive SQL queries and Java code. The integration of Spring JDBC helps alleviate the need for substantial Java code.

As the discussion advances to JPA (Java Persistence API), the focus shifts towards the mapping of entities to tables and leveraging the entity manager, thereby diminishing the necessity of manually crafting queries.

The conversation then introduces Spring Data JPA, which strives to further streamline JPA functionality. With Spring Data JPA, developers are relieved from concerns about the entity manager, as the framework manages it seamlessly. The process of creating a Spring Data JPA repository interface for a "Course" entity is exemplified, extending the JPA repository interface.

The Spring Data JPA repository offers a range of methods such as save, delete, find by ID, simplifying various database operations. The transition from using a JDBC repository to the new Spring Data JPA repository is demonstrated in a course command line runner class, illustrating the ease of adoption.

Advantages of Spring Data JPA include a significant reduction in code, where developers only need to create an interface. The inherent functionality of Spring Data JPA automates numerous database operations, enhancing the accessibility and convenience of JPA for developers. This concludes by highlighting the journey from Spring JDBC to JPA and ultimately to Spring Data JPA, underscoring the achieved simplicity with Spring Data JPA.

----------------------------------------------------
Exploring features of Spring Data JPA (Eight commit)
----------------------------------------------------

The discussion revolves around the utilization of Spring Data JPA within a Java application. The initial focus lies on understanding Spring JDBC, JPA, and subsequently, Spring Data JPA. The narrative then transitions to the command line runner, showcasing practical implementation of Spring Data JPA repository methods.

The usage of `repository.findAll()` is illustrated to retrieve and print all courses through `System.out.println`. The significance of `repository.count()` is underscored for entity counting. An integral feature of Spring Data JPA Repositories, permitting the incorporation of custom methods, is introduced.

A specific custom method, `findByAuthor`, is exemplified, adhering to a prescribed naming convention. The application of this custom method for author-based course searches is demonstrated. The discussion extends the concept of naming conventions and custom methods to include searching by course name, employing `findByName`.

The execution of the application is detailed, presenting the query results and showcasing the operational aspects of the implemented methods. The journey spanning from Spring JDBC to JPA to Spring Data JPA is succinctly summarized, emphasizing the advantages and adaptability offered by Spring Data JPA in database operations.

---------------------------------
- **Hibernate versus JPA:**
  - **JPA (Java Persistence API):**
    - JPA is an API (Java Persistence API) that defines a specification.
    - It acts like an interface and defines how to define entities using annotations.
    - Examples include `@Entity` for entities and `@Id` for primary keys.
    - It allows mapping of attributes using annotations like `@Column`.
    - Provides methods for entity management through the entity manager.
  - **Hibernate:**
    - Hibernate is a popular implementation of JPA.
    - It is one of the implementations that follow the JPA specification.
    - In code, you can use Hibernate directly by using Hibernate annotations, but it's not recommended.
    - Recommended approach: Use JPA in code and have Hibernate as the implementation by adding Hibernate JAR to the classpath.
    - This allows flexibility to switch to other JPA implementations, like Toplink, without being locked into Hibernate.
  - **Dependency Management:**
    - Both Hibernate and JPA dependencies are included through `springboot-starter-data-jpa` in the `pom.xml`.
    - JPA is used in the code with annotations, and Hibernate is used as its implementation.

**Key Takeaway:**
- **JPA is an API** that defines how to map entities, attributes, and use the entity manager.
- **Hibernate is an implementation** of the JPA specification.
- **Recommended practice** is to use JPA annotations in code to avoid being locked into a specific implementation, but Hibernate is often used as the underlying provider.
