package com.learn.restapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class PropertiesConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
