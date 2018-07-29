package com.github.wenweihu86.inventory.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServerApplication.class, args);
    }
}
