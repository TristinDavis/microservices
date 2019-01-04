package io.github.bhuwanupadhyay.inventory.event;

import lombok.Getter;

@SuppressWarnings("WeakerAccess")
@Getter
public class InventoryEvent<T> {

    public final T id;

    public InventoryEvent(T id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this.id = id;
    }
}