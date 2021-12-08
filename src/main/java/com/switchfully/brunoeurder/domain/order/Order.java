package com.switchfully.brunoeurder.domain.order;

import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;
import com.switchfully.brunoeurder.repository.itemGroup.ItemGroupRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private final String orderUniqueID;
    private final List<ItemGroup> itemGroup;
    private Double orderPrice;

    public Order(List<ItemGroup> itemGroup, Double orderPrice) {
        this.orderUniqueID = UUID.randomUUID().toString();
        this.itemGroup = Objects.requireNonNull(itemGroup, "Value missing");
        this.orderPrice = getOrderPrice();
    }

    public String getOrderUniqueID() {
        return orderUniqueID;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }

    public Double getOrderPrice() {return orderPrice;
    }

    @Override
    public String toString() {
        return "Record for order " + getOrderUniqueID() +
                ":\n" + "Items: " + itemGroup +
                ":\n" + "Total price: " + getOrderPrice();
    }
}

