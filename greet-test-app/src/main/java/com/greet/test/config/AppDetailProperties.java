package com.greet.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app-detail")
public record AppDetailProperties(String name, String version) {

  @Override
  public String toString() {
    return "AppDetailProperties{" + "name='" + name + '\'' + ", version='" + version + '\'' + '}';
  }
}
