Challenge for Transperfect (BackEnd)

The challenge create a REST API for managing imaginary Issues.

Tools and Frameworks I used:

- Spring Boot 1.5.7
- Spring Data MongoDB
- MongoDB Embedded
- Swagger UI
- Cucumber for Functional Test
- Junit and Mockito for Unitary Test

All the code are in GitHub and exist an image of this in DockerHub*.

The project is structured in:
- Controllers
- Services
- Repositories

There are two Controller, both are annotated with swagger annotations. These give us a friendly front end for check all
the methods.

There is only one Service (interface and implementation) for accesing all methods in the Repository.

Again, we have a Repository, where we do all the calls to Mongo. In this case, we only have an interce, spring data
provide us the implementation.

In MongoDB we only have one colecction, cause it is not necesary any other. We should remeber that the approuch we use
in NoSQL it should not be the same than Relational Databases.

For avoid tools like postman, curl... I included and configured swagger in the project. This give us a user friendly
(well, at least useful :) ) front end enviroment. From there, we can use all the servers and check the responses.

For testing, I have created two different classes of test:

- Unitary Test:
    In this case, I have developed test with mockito for the Controllers and the Service.

- Functional Test:
    For functional test, I have included cucumber, making use of gherkins for a natural way of write a test. I like this
    because for the people who write the test, it is not necesary to be a developer. Anyone with functional knologe
    can write test. Later, a developer can implement this test. In this case, using as example, I only cover one of the
    controller. There is a .feature file with three scenarios for test. I think this is very useful in a project, but
    I haven't got more time for make the rest. I think with these three scenarios, the idea is clear how it works.

The different url:

- GitHub:

    https://github.com/raulsanchez1981/translations_test

- DockerHub:

    https://hub.docker.com/r/raulsanchez1981/translations-challenge/

- For enter in the application with Swagger:

    http://localhost:8080/translations/swagger-ui.html

For any doubts, my mail is: raulsanchez1981@gmail.com




*The image in DockerHub is not working because an error between Linux Alpine and MongoDB embedded. I checked if there is
 a possible solution, but I only found the alternative of install another image with mongoDB. Maybe could be created
 with docker compose, but haven't any more time. If you download the code in GitHub, you can run it without any problem.