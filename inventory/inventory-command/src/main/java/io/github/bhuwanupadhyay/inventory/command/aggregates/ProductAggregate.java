package io.github.bhuwanupadhyay.inventory.command.aggregates;

import io.github.bhuwanupadhyay.inventory.command.commands.AddProductCommand;
import io.github.bhuwanupadhyay.inventory.events.ProductAddedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

@Slf4j
public class ProductAggregate extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;
    private String name;

    @CommandHandler
    public ProductAggregate(AddProductCommand command) {
        LOG.debug("Command: 'AddProductCommand' received.");
        LOG.debug("Queuing up a new ProductAddedEvent for product '{}'", command.getId());
        apply(new ProductAddedEvent(command.getId(), command.getName()));
    }


}
