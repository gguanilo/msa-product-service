# msa-product-service

<h1 align="center"> Project API Products </h1> <br>

<p align="center">
  Challenge Falabella
</p>


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)
- [Acknowledgements](#acknowledgements)




## Introduction

TODO: Replace with introduction

## Features
TODO: Description of features

* Crud of entity products
* Coverage covered > 85%
* web server features


## Requirements
The application can be run locally , the requirements for each setup are listed below.



### Local
* [Java 11 SDK](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Gradle](https://gradle.org/releases/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [H2 Database](https://spring.io/projects/spring-boot)



## Quick Start
TODO:

### Run Local
```bash
$ ./gradlew bootRun
```

Application will run by default on port `8080`

Configure the port by changing `server.port` in __application.properties__


## Testing
Execute test cases of project.
```bash
$ ./gradlew test 
```
Validation code covered , entire application.
```bash
$ ./gradlew jacocoTestCoverageVerification 
```
Generate Report for the coverage.
```bash
$ ./gradlew jacocoTestReport 
```

## Sample Data for Testing
Item 1
```bash
curl --location --request POST 'http://localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sku":"FAL-8406270",
    "name":"500 Zapatilla Urbana Mujer",
    "brandName":"NEW BALANCE",
    "size":"37",
    "price":42990.00 ,
    "urlImage":"https://falabella.scene7.com/is/image/Falabella/8406270_1"
}'
```
Item 2
```bash
curl --location --request POST 'http://localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sku":"FAL-881952283",
    "name":"Bicicleta Baltoro Aro 29",
    "brandName":"JEEP",
    "size":"ST",
    "price":399990.00 ,
    "urlImage":"https://falabella.scene7.com/is/image/Falabella/881952283_1"
}'
```
Item 3
```bash
curl --location --request POST 'http://localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sku":"FAL-881898502",
    "name":"Camisa Manga Corta Hombre",
    "brandName":"BASEMENT",
    "size":"M",
    "price":24990.00 ,
    "urlImage":"https://falabella.scene7.com/is/image/Falabella/881898502_1"
}'
```

## API
TODO: API Reference with examples, or a link to a wiki or other documentation source.

## Acknowledgements
TODO: Show folks some love.
