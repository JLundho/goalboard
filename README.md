#Goalsky WIP
The user can GET/POST/PUT/DELETE goals using familiar REST-operations and persist (for a short while) to the database

##Goals with the project
Goalsky is a RESTful API that was created in an effort to learn:
* RESTful principles
* Using Jersey to develop RESTful web services
* Storing data using the JPA Entity Manager and Hibernate.

##Database specifics
Connections to the database are made through crude JDBC-connections to a Derby-database. The database-queries are constructed at runtime. 

##Possibilities of improvement
* Abstract out DB connection statements from code
* Create query builder and use prepared statements (if SQL-queries in the code are to remain)
* Rewriting the whole thing to Spring or Django in order to better leverage dependency injection, testing and add additional functionality :)

##Known bugs:
* The JPA clears the database after every operation has been performed. For example, a user of the API can store create a goal using a REST-client(such as Postman) by sending a JSON-request to http://localhost:<port>/goalsky/webapi/goals and the goal will be stored in the Derby Database until the next transaction is performed.

A possible explanation is due to the fact that a new instance of the entityManager is retrieved when the DAO is accessed, instead of once in the service (and reaccéssed later)