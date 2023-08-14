package com.greet.test;

import io.micrometer.core.instrument.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.greet.test.GreetTestApplication.APP_VERSION;

@RestController
public class HomeController {

  private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
  private Counter greetCounter;

  public HomeController(Counter greetCounter) {
    this.greetCounter = greetCounter;
  }

  @GetMapping("/greet/{id}")
  public String greet(@PathVariable int id) {
    String response = " Hello 👋 " + APP_VERSION + " ";
    LOGGER.info("Greeting id {} with --> {}", id, response);
    greetCounter.increment();
    return response;
  }

}
