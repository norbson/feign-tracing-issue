package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ExternalService", url = "localhost:8080")
public interface ExternalService {

  @GetMapping(value = "/external",
              produces = MediaType.APPLICATION_JSON_VALUE,
              consumes = MediaType.APPLICATION_JSON_VALUE)
  ExternalDto request();


  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  class ExternalDto {

    int status;
  }
}
