package io.github.bhuwanupadhyay.inventory.command.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@RequiredArgsConstructor
@Getter
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final String name;

}
