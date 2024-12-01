package com.hs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicaiton.class, args);
    }

}
