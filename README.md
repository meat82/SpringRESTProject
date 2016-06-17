## Synopsis

This is sandbox project which purpose is to test Spring RestTemplate usage. Data is fetch from https://www.stattleship.com/ which provides sports data from basketball, football, baseball and hockey.

Data is received in JSON format which is parsed by using Spring RestTemplate

## Motivation

Purpose for this project is to find needed hockey data as easily as possible.

## Installation

Following softwares are required:
- JDK7
- Gradle

1) Get own security token from https://www.stattleship.com/

2) Add security token into security.key file

3) Go to project root and run: gradle createJAR

4) Executable jar file is created into folder build/libs

5) Run example: java -jar RestData-1.0.jar nhl-car


## API Reference

Stattleship API: http://developers.stattleship.com/#introduction

SpringBoot API: http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/

## Contributors


## License
