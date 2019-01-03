package io.github.bhuwanupadhyay.inventory.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryCommandApp {

    public static void main(String[] args) {
        SpringApplication.run(InventoryCommandApp.class, args);
    }

}
