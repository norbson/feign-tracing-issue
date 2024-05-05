package com.example.demo;

import com.example.demo.ExternalService.ExternalDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Value
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TracingTestController {

  ExternalService externalService;

  @GetMapping("/test")
  public TestDto test() {
    log.info("Before Feign Observation started");
    TestDto response = new TestDto(externalService.request().getStatus());
    log.info("After Feign Observation finished");
    return response;
  }

  @GetMapping("/external")
  public ExternalDto external() {
    log.info("External service Observation started");
    ExternalDto response = new ExternalDto(1);
    log.info("External service Observation almost finished");
    return response;
  }

  @Data
  @AllArgsConstructor
  public static class TestDto {
    int status;
  }
}
