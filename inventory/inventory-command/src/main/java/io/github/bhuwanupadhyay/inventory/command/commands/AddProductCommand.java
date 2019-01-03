package io.github.bhuwanupadhyay.inventory.command.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

@RequiredArgsConstructor
@Getter
public class AddProductCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final String name;

}
