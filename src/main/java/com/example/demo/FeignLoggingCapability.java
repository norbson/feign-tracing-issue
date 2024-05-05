package com.example.demo;

import feign.Capability;
import feign.Client;
import feign.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignLoggingCapability implements Capability {

  @Override
  public Client enrich(Client client) {
    return (request, options) -> {
        log.info("Feign observation already started");
        Response response = client.execute(request, options);
        log.info("Before feign observation finished");
        return response;
    };
  }
}
