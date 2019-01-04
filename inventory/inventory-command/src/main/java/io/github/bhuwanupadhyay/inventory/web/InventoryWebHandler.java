package io.github.bhuwanupadhyay.inventory.web;

import io.github.bhuwanupadhyay.inventory.command.CreateProductCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandExecutionException;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
@Slf4j
class InventoryWebHandler {

    private final CommandBus commandBus;

    Mono<ServerResponse> createProduct(ServerRequest request) {
        LOG.debug("Creating product [{}]", request.attributes());
        return request.bodyToMono(CreateProductRequest.class)
                .flatMap(productRequest -> {
                    String name = productRequest.getName();
                    String id = newId();
                    CreateProductCommand command = new CreateProductCommand(id, name);
                    commandBus.dispatch(new GenericCommandMessage<>(command));
                    LOG.info("Created product [{}] '{}'", id, name);
                    return ok().build();
                })
                .doOnError(AssertionError.class, e -> LOG.warn("Create Request FAILED with Message: {}", e.getMessage()))

                .onErrorResume(AssertionError.class, e -> badRequest().build())

                .doOnError(CommandExecutionException.class, e -> LOG.warn("Create Command FAILED with Message: {}", e.getMessage()))

                .onErrorResume(CommandExecutionException.class, e -> badRequest().build());
    }

    private String newId() {
        return UUID.randomUUID().toString();
    }

}
