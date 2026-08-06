package com.apps.operationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

// "AUTH-SERVICE" is resolved through Eureka (spring.application.name of
// auth-service), and the actual host:port is chosen by Spring Cloud
// LoadBalancer — this is the "load balancing" piece: if you ever ran two
// instances of auth-service, calls would be spread across both.
@FeignClient(name = "AUTH-SERVICE")
public interface AuthServiceClient {

    @GetMapping("/api/auth/validate")
    TokenValidationResponse validate(@RequestHeader("Authorization") String authorizationHeader);
}
