# Spring boot simple weather app

## Struktura databáze
* historie table - sloupce:
	* UUID id
	* Text mesto
	* Date datum
	* double teplota

## Controller endpointy
* / - zde se nachází index stránky
* /saveRecord - zde probíhá uložení záznamu do databáze a následky redirect i s atributy zpátky na index


## Services
* WeatherService - interakce s openweathermap api, vrácení momentální teploty
* HistoryRecordService - zde dochází k práci s záznamy hledání

## Application properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/homework
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```


## Testy
Pro integrační testy jsem použil Testcontainers (viz https://www.testcontainers.org/)

## openweathermap-java-api
Pro interakci s openweathermap jsem použil knihovnu openweathermap-java-api (viz https://github.com/Prominence/openweathermap-java-api/blob/master/docs/Release_2.2.0.md)
