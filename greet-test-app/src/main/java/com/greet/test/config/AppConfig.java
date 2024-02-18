package com.greet.test.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {AppDetailProperties.class})
public class AppConfig {

  AppDetailProperties appDetailProperties;

  public AppConfig(AppDetailProperties appDetailProperties) {
    this.appDetailProperties = appDetailProperties;
    System.out.println(appDetailProperties);
  }

  @Bean
  public Counter greetCounter(MeterRegistry registry) {
    return Counter
        .builder("greeting")
        .description("Count total greeting")
        .tag("app-version", appDetailProperties.version())
        .register(registry);
  }


}
