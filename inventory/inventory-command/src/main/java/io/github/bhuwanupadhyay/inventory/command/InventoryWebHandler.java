package io.github.bhuwanupadhyay.inventory.command;

import io.github.bhuwanupadhyay.inventory.command.commands.AddProductCommand;
import io.github.bhuwanupadhyay.inventory.utils.Asserts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.repository.ConcurrencyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
@RequiredArgsConstructor
@Slf4j
class InventoryWebHandler {

    private final CommandGateway gateway;

    Mono<ServerResponse> createProduct(ServerRequest request) {
        LOG.debug("Creating product [{}]", request.attributes());
        Mono<Map<String, String>> body = request.bodyToMono(LinkedHashMap.class);
        return body
                .flatMap(map -> {
                    String name = map.get("name");
                    String id = newId();
                    Asserts.INSTANCE.areNotEmpty(Arrays.asList(id, name));
                    AddProductCommand command = new AddProductCommand(id, name);
                    gateway.sendAndWait(command);
                    LOG.info("Added product [{}] '{}'", id, name);
                    return ok().build();
                })
                .doOnError(AssertionError.class, e -> LOG.warn("Add Request failed with Message: {}", e.getMessage()))

                .onErrorResume(AssertionError.class, e -> badRequest().build())

                .doOnError(CommandExecutionException.class, e -> LOG.warn("Add Command FAILED with Message: {}", e.getMessage()))

                .onErrorResume(CommandExecutionException.class, e -> {
                    if (e.getCause() != null) {
                        LOG.warn("Caused by: {} {}", e.getCause(), e.getCause());
                        if (e.getCause() instanceof ConcurrencyException) {
                            LOG.warn("A duplicate product with the same ID already exists.");
                            return status(HttpStatus.CONFLICT).build();
                        }
                    }
                    return badRequest().build();
                });
    }

    private String newId() {
        return UUID.randomUUID().toString();
    }

}
