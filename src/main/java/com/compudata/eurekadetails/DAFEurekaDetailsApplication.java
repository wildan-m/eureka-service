package com.compudata.eurekadetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application class for the DAF-EurekaDetails service.
 * This service allows clients to query Eureka server instances and retrieve service details.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DAFEurekaDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DAFEurekaDetailsApplication.class, args);
    }
}
