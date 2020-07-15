package com.microservice.currencyExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	CurrencyExchangeService currencyExchangeService;
	
	@GetMapping("/currency-exchange/{from}/to/{to}")
	public ExchangeValueBean getExchangeValueForCurrency(@PathVariable String from, @PathVariable String to)
	{
		System.out.println("check for autowiring in controller-before");
		ExchangeValueBean exchangeValue = currencyExchangeService.getExchangeRateFromService(from,to);
		System.out.println("check for autowiring in controller-after"+exchangeValue);
		return exchangeValue;
	}
}
