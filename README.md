# myRetail - Read me
My Retail API - POC 

## Technologies used - 

Java 8 

Spring Boot

Mongo DB Embadded Database 

Junit for test cases

Lombok For Data/Getter/Setters

Swagger UI for - Exploring the Endpoints - http://localhost:8181/swagger-ui.html#/

PostMan collection - https://www.getpostman.com/collections/819daea7480a8f605a9d

### RestFul APIs end point 

##Get Method  - http://localhost:8080/product/13860428

Response Json - 
{
    "id": 13860428,
    "name": "The Big Lebowski (Blu-ray)",
    "current_price": {
        "value": 44646.32,
        "currency_code": "USD"
    }
}


##Put Method  - http://localhost:8080/product/1386042

request
Body 
{
  "currencyCode": "USD",
  "currentPrice": 1002.32
}

Response Body
{
    "id": 1386042,
    "current_price": {
        "value": 44646.32,
        "currency_code": "USD"
    }
}


## Validations

if id < 1000 -> Http code return 500

if currency code is not USD and price is less then zero - Http code return 400

In order to get the success response data should be return from NOSQL DB (Price) and Product API ( Item Description)


##Troubleshooting -

This is a gradle project and can be build using "gradle build" command

Lombok needs to be installed in eclipse or intellJ

