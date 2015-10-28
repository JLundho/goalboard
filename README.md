Goalsky is a WIP RESTful API and my personal project. It was created in an effort to learn:
* RESTful principles
* Using the framework Jersey to develop RESTful web services
* Storing data using Hibernate and the Java Persistence API (JPA).

At the time of writing, the user can GET/POST/PUT/DELETE using familiar REST-operations. 

Known bugs:
* The project is currently not in a working state (1. javax.persistence.PersistenceException: Unable to build entity manager factory)
* The JPA clears the database after every operation has been performed. For example, a user of the API can store create 
a goal using a REST-client(such as Postman) by sending a JSON-request to http://localhost:<port>/goalsky/webapi/goals and 
the goal will be stored in the Derby Database until the next transaction is performed.
