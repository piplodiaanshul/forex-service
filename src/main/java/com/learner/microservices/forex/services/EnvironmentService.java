package com.learner.microservices.forex.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentService {

  private static final String ZERO = "0";
  @Autowired
  private Environment environment;

  public String getLocalServerPort() {
    return Optional.ofNullable(environment)
        .map(environment -> environment.getProperty("local.server.port"))
        .orElse(ZERO);
  }
}
