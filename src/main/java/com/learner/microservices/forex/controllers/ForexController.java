package com.learner.microservices.forex.controllers;

import com.learner.microservices.forex.jpa.repos.ExchangeValueRepository;
import com.learner.microservices.forex.models.ExchangeValue;
import com.learner.microservices.forex.services.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

  @Autowired
  private EnvironmentService environmentService;

  @Autowired
  private ExchangeValueRepository exchangeValueRepository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue fetchExchangeValue(@PathVariable String from, @PathVariable String to) {
    ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
    String localPort = environmentService.getLocalServerPort();
    exchangeValue.setPort(Integer.parseInt(localPort));
    return exchangeValue;
  }


}
