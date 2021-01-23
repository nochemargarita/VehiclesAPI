package com.udacity.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Creates a Spring Boot Application to run the Pricing Service.
 * TODO: Convert the application from a REST API to a microservice.
 */
@SpringBootApplication
@EnableEurekaClient
public class PricingServiceApplication {
    //    /services/price?vehicleId=4 for testing if the service started successfuly aside from checking in Eureka server
    public static void main(String[] args) {
        SpringApplication.run(PricingServiceApplication.class, args);
    }

}
