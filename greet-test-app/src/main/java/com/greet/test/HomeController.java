package com.greet.test;

import com.greet.test.config.AppDetailProperties;
import io.micrometer.core.instrument.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

  private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
  private final Counter greetCounter;
  private final AppDetailProperties appDetailProperties;

  public HomeController(Counter greetCounter, AppDetailProperties appDetailProperties) {
    this.greetCounter = greetCounter;
    this.appDetailProperties = appDetailProperties;
  }

  @GetMapping("/greet/{id}")
  public String greet(@PathVariable int id) {
    String response = """
        {
        "greeting": "Hello 👋",
        "id": %d,
        "version": "%s"
        }
        """.formatted(id, appDetailProperties.version());

    LOGGER.info(response);
    greetCounter.increment();
    return response;
  }

}
