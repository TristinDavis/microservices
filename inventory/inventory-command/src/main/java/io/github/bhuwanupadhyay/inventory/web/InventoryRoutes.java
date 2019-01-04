package io.github.bhuwanupadhyay.inventory.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
class InventoryRoutes {

    private final InventoryWebHandler handler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return nest(
                path("/inventories"),
                nest(
                        accept(APPLICATION_JSON),
                        route(POST("/")
                                .and(contentType(APPLICATION_JSON)), handler::createProduct)
                )
        );
    }


}
