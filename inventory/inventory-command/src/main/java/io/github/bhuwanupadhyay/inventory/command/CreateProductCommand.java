package io.github.bhuwanupadhyay.inventory.command;

import io.github.bhuwanupadhyay.inventory.InventoryCommand;
import lombok.Getter;

@Getter
public class CreateProductCommand extends InventoryCommand<String> {

    private final String name;

    public CreateProductCommand(String id, String name) {
        super(id);
        this.name = name;
    }
}
