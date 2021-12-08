package com.switchfully.brunoeurder.domain.order;

import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private final String orderUniqueID;
    private final String userUniqueID;
    private final List<ItemGroup> itemGroup;
    private Double orderPrice;

    public Order(List<ItemGroup> itemGroup) {
        this.orderUniqueID = UUID.randomUUID().toString();
        this.userUniqueID = UUID.randomUUID().toString();
        this.itemGroup = Objects.requireNonNull(itemGroup, "Value missing");
        this.orderPrice = getOrderPrice(itemGroup);
    }

    public String getOrderUniqueID() {
        return orderUniqueID;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }

    public Double getOrderPrice(List<ItemGroup> itemGroup) {
        Double orderPrice = 0.0;
        for (ItemGroup group : itemGroup) {
            orderPrice += group.getQtyOrdered()*group.getItem().getItemPrice();
        }
        return orderPrice;
    }

    @Override
    public String toString() {
        return "Record for order " + getOrderUniqueID() +
                ":\n" + "Items: " + itemGroup +
                ":\n" + "Total price: " + getOrderPrice(itemGroup);
    }
}

