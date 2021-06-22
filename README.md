Ekahau web service exercise

Description
Implement a Java web application with RESTful services that will allow the user to execute CRUD operations on the books in a repository. In this
exercise the "C" (create), "R" (read), and "D" (delete) operations are sufficient.

Requirements
When run locally, the application's services are available at http://localhost:8080/api/v1/books.
The user can run the test scripts from folder src/test/scripts and get expected results.
The executed actions will update the database.
The applicant is able to explain his/her solution (what and why).

Optional Functionalities (Bonus)
Add security with HTTP basic authentication (defining the user and password in code is just fine in this exercise)
Add a few unit tests (maybe utilizing mocking?)

Details
The example project skeleton is based on Maven, Java 8 and Spring Boot. If you prefer, you can pick another Java framework. Please note that
the reviewer should be able to run the solution with a single command without the need to install additional software on her machine.
The Spring Boot app can be run with this command:

mvn spring-boot:run

The project file "ekahau-exercise.zip" contains the Maven project that you can use as a starting point for your solution.
There are three existing classes:
Main - the entry point that will enable Spring Boot to initialize
DataSourceConfiguration - a configuration class that will initialize a HSQL database. You can
find the database schema definition (exercise-db.sql) and data initialization (exercise-db-data
.sql) files from folder ekahau-exercise/src/main/resources.
HelloController - an example interface that can be tested with script ekahau-exercise/src/test/
scripts/hello.sh.
The test scripts can be found from folder ekahau-exercise/src/test/scripts:
listBooks.sh - Fetches all the books from the service
addBook.sh - adds a book to the service (data in JSON format)
deleteBook.sh - deletes a book from the service (by id)

How to run the project.

Basic security for the api has been implemented 
so before accessing the APIs we need to register user in db. 
Make post method call to http://localhost:8080/user/signup

{     
    "username": "test3",
    "password": "test1234"
}

![image](https://user-images.githubusercontent.com/45309427/123003514-f6ecef00-d3bb-11eb-82ba-c922b0a0a366.png)

then make the post to url 

http://localhost:8080/login

{     
    "username": "test3",
    "password": "test1234"
}

![image](https://user-images.githubusercontent.com/45309427/123003720-4af7d380-d3bc-11eb-8414-e6b0cee94005.png)


copy the Authorization string and this JWT token will be active for 15 minutes only.
After getting the token we can make request to the APIs , without a valid token , we will be getting the Access Denied 

with the token we will be getting the results 

![image](https://user-images.githubusercontent.com/45309427/123004152-eab56180-d3bc-11eb-9d75-e46e2d419b79.png)

