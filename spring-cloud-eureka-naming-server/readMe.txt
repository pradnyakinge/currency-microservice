Setting Eureka naming server :

1. create project with dependencies Eureka Server, Config Client, Actuator, Devtool.
 
2. Enable main class as @EnableEurekaServer

3. update application.proerties file:
	eureka.client.register-with-eureka=false
	eureka.client.fetch-registry =false
	
4. run the application on: http:localhost:8761 -----> we will get eureka server platform

Now we want our microservices to be registered on Eureka naming server. To do so, follow below steps:
1. Regestering Currency Conversion microservice to eureka 
	
	==> 1. add Eureka server configuration in Currency Conversion service by updating pom.xml(add dependency) , and add @EnableDiscoveryClient to main class.
	    2. update application.properties 
	    
	==> run Eureka server on : localhost:8761 and hen run Currency Conversion service then we can see Currency Conversion service instance is created on Eureka Server portal.
	    lly for currency exchange service and limit service.
	    
	    
Now, remember, we have created 2 instences of Currency Calculation Service by using : currency-exchange-service.ribbon.listOfServers=http://localhost:8000, http://localhost:8001
--> Now , we configure Eureka Server, to make a dynamic fatch and use of currency exchange microservice instance by currecny calculation service using naming server, we need to reove the hardcoaded listOfServers from application.properties of Currrency Conversion service
