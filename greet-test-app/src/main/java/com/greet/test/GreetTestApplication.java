package com.greet.test;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GreetTestApplication {

  @Value("${appVersion}")
  public String appVersion;
  public static String APP_VERSION;

  public static void main(String[] args) {
    SpringApplication.run(GreetTestApplication.class, args);
  }

  @Value("${appVersion}")
  public void setNameStatic(String appVersion){
    GreetTestApplication.APP_VERSION = appVersion;
  }

  @Bean
  public Counter greetCounter(MeterRegistry registry) {
    return Counter.builder("greeting")
        .description("Count total greeting")
        .tag("app-version", APP_VERSION)
        .register(registry);
  }

}
