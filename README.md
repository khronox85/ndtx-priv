# Inditex Core Platform Technical Test

## Sumary

Application using the Spring Boot framework that provides a REST access point for querying this price database.

* Input parameters are the query (or application) date, the product identifier, and the brand identifier.
* Provide as output the product identifier, the brand identifier, the applicable rate, the date range during which the price applies, and the final price to be applied.

## Technology

* Java 21
* Springboot 3.4.5
* H2 local Database Java Sql
* Swagger

# Execution

# Usage

Once the application is launched, the service can be used via:

* Swagger: http://localhost:8080/swagger-ui/index.html
* Endpoint example: http://localhost:8080/price?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1

# Additional comments

* An additional column PRICE_ID has been added to the PRICES table as the primary key of the table, to avoid generating a composite key.
* There are no comments on the classes or methods because they are self-explanatory in their nomenclature.