package com.microservice.currencyConversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	/* This is how we can call another rest service in our application(using restTemplate)
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCoversionBean convertCurrency(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity)
	{
		Map <String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		ResponseEntity<CurrencyCoversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyCoversionBean.class, uriVariable);
		
		CurrencyCoversionBean response = responseEntity.getBody();
		return new CurrencyCoversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
	}*/
	
	@GetMapping("currency-converter/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCoversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity)
	{
		System.out.println("in feign url");
		CurrencyCoversionBean response = currencyExchangeServiceProxy.getExchangeValueForCurrency(from, to);
		return new CurrencyCoversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
	}

}
