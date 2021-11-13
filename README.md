# ldms

Spring Boot application implementing the amortisation requirements

To run, build the project using maven and then run as a Java application

`DemoApplication`

as a java application or run the spring-boot:start maven target

Note I am using Lombok so an IDE will need the Lombok plugin

The application starts on the default 8080 port. I construct a demonstration LoanDetails as part of startup and this should
be discoverable from the entry link  (http://localhost:8080/ - which will take you to http://localhost:8080/loanDetails)

sample post

` curl -X POST http://localhost:8080/loanDetails -H "Content-Type:application/json" -d "{\"numberOfMonthlyPayments\":12,\"assetCost\":20000.0,\"deposit\":5000.0,\"interestRate\":7.5,\"balloonPayment\":0.0}"`

## Thoughts

1. obviously I wouldn't use doubles as a monetary type in a production application
2. rounding needs tidying up, amounts end up being out by a penny
3. really interesting design decisions to take. I considered inheritence for the two types of amortisation schedules but decided against it, the jury is still out  
