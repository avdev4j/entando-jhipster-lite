package com.mycompany.myapp.cucumber;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import tech.jhipster.lite.cucumber.CucumberTestContext;

import com.mycompany.myapp.JhipsterSampleApplicationApp;
import com.mycompany.myapp.cucumber.CucumberConfiguration.CucumberRestTemplateConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = { JhipsterSampleApplicationApp.class, CucumberRestTemplateConfiguration.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CucumberConfiguration {

  @Autowired
  private TestRestTemplate rest;

  @Before
  public void resetTestContext() {
    CucumberTestContext.reset();
  }

  @Before
  public void loadInterceptors() {
    ClientHttpRequestFactory requestFactory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());

    RestTemplate template = rest.getRestTemplate();
    template.setRequestFactory(requestFactory);
    template.setInterceptors(Arrays.asList(mockedCsrfTokenInterceptor(), saveLastResultInterceptor()));
    template.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
  }

  private ClientHttpRequestInterceptor mockedCsrfTokenInterceptor() {
    return (request, body, execution) -> {
      request.getHeaders().add("mocked-csrf-token", "MockedToken");

      return execution.execute(request, body);
    };
  }

  private ClientHttpRequestInterceptor saveLastResultInterceptor() {
    return (request, body, execution) -> {
      ClientHttpResponse response = execution.execute(request, body);

      CucumberTestContext.addResponse(request, response, execution, body);

      return response;
    };
  }
  
  @TestConfiguration
  static class CucumberRestTemplateConfiguration {

    @Autowired
    private TestRestTemplate rest;

    @Bean
    CucumberRestTemplate cucumberRestTemplate() {
      return new CucumberRestTemplate(rest);
    }
  }
}
