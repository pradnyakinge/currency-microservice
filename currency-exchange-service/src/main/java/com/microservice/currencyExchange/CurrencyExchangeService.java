package com.microservice.currencyExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeReository CurrencyExchangeRepository;

	public ExchangeValueBean getExchangeRateFromService(String from, String to) {
		System.out.println("inside service class-before");
		
		ExchangeValueBean exchangeValue = CurrencyExchangeRepository.findByFromAndTo(from,to);
		
		System.out.println("inside service class-after");
		return exchangeValue;
	}

}
