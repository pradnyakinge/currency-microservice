package com.microservice.currencyConversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//@FeignClient(name = "currency-exchange-service", url = "localhost:8000") // this urls we configure in application.properties file.
//note : this details are of CurrencyExchangeService. We need to call the api of CurrencyExchangeService in this application. Like we did using restTemplpate.

//@FeignClient(name = "currency-exchange-service")


@FeignClient("netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")  
public interface CurrencyExchangeServiceProxy {
	
	//taking this method from currency exchange service. as we need to consume this "/currency-exchange/{from}/to/{to}" in our application. like restTemplate.
	
	
	@GetMapping("/currency-exchange-service/currency-exchange/{from}/to/{to}")
	public CurrencyCoversionBean getExchangeValueForCurrency(@PathVariable("from") String from, @PathVariable("to") String to);

}
// this interfae mean that , we are enabling the proxy which uses above api url in our application.