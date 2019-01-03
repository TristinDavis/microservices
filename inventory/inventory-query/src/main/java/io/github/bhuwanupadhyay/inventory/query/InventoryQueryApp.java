package io.github.bhuwanupadhyay.inventory.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryQueryApp {

    public static void main(String[] args) {
        SpringApplication.run(InventoryQueryApp.class, args);
    }

}
