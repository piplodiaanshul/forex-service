package com.learner.microservices.forex.jpa.repos;

import com.learner.microservices.forex.models.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

  ExchangeValue findByFromAndTo(String from, String to);

}
