package com.switchfully.brunoeurder.domain.order;

import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;

import java.util.List;

public class OrderDto {

    private String orderUniqueID;
    private List<ItemGroup> itemGroup;
    private Double orderPrice;

    public String getOrderUniqueID() {
        return orderUniqueID;
    }

    public OrderDto setOrderUniqueID(String orderUniqueID) {
        this.orderUniqueID = orderUniqueID;
        return this;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }

    public OrderDto setItemGroup(List<ItemGroup> itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public OrderDto setPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    @Override
    public String toString() {
        return "Record for order " + getOrderUniqueID() +
                ":\n" + "Items: " + itemGroup +
                ":\n" + "Total price: " + getOrderPrice();
    }
}
