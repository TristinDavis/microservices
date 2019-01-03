package io.github.bhuwanupadhyay.inventory.command;

import io.github.bhuwanupadhyay.inventory.utils.Asserts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
class InventoryHandler {

    private final CommandGateway gateway;

    public Mono<ServerResponse> createProduct(ServerRequest request) {

        LOG.debug("Adding product [{}]", "");

        Mono<Map> body = request.bodyToMono(LinkedHashMap.class);

        body.flatMap(map -> {
            Asserts.INSTANCE.isNotEmpty(map.get(""));
        })

        return ServerResponse.ok().build(this.repository.savePerson(body));
    }

}
