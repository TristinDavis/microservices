package io.github.bhuwanupadhyay.inventory;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryCommandApp {

    public static void main(String[] args) {
        SpringApplication.run(InventoryCommandApp.class, args);
    }

    @Bean
    public CommandBus commandBus() {
        return new SimpleCommandBus();
    }

}
