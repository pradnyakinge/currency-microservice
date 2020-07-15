package com.microservice.currencyExchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeReository extends JpaRepository<ExchangeValueBean, Long>{
	
	 ExchangeValueBean findByFromAndTo(String from, String to);

}
