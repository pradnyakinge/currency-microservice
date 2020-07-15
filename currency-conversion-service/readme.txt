How to integrate feign:

1. add dependency in pom.xml
2. Enable feign using : @EnableFeignClients("com.microservice.currencyConversion"). 
3. create feign proxy by creating interface :CurrencyExchangeServiceProxy and annoted it with @FeginClient

	--> @FeignClient(name = "currency-exchange-service", url = "localhost:8000")
	                 name is from application.properties file of CurrencyExchangeService, which is running on uri: localhost:8080
	--> We have to define a method to talk to currency exchange service: so to do so , take the defination of the method from currencyExchangeServie and paste in this interface.
	--> onle need to change the bean defination class.
	
and now , call this interface from controller by autowiring it.
===========================================================================================================================================================================================

Client Side Load Balancing :

 
