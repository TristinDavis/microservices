package io.github.bhuwanupadhyay.inventory.command.aggregates;

import io.github.bhuwanupadhyay.inventory.command.commands.CreateProductCommand;
import io.github.bhuwanupadhyay.inventory.events.ProductCreatedEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Slf4j
@Getter
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private String name;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        LOG.debug("Command: 'CreateProductCommand' received.");
        LOG.debug("Queuing up a new ProductCreatedEvent for product '{}'", command.getId());
        apply(new ProductCreatedEvent(command.getId(), command.getName()));
    }

    @EventSourcingHandler
    private void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        LOG.info("Applied: 'ProductCreatedEvent' [{}] '{}'", event.getId(), event.getName());
    }

}
