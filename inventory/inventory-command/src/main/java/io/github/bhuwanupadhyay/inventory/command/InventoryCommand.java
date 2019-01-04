package io.github.bhuwanupadhyay.inventory.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.util.Assert;

@SuppressWarnings("WeakerAccess")
@Getter
public class InventoryCommand<T> {
    @TargetAggregateIdentifier
    public final T id;

    public InventoryCommand(T id) {
        Assert.notNull(id, "Id cannot be null");
        this.id = id;
    }
}