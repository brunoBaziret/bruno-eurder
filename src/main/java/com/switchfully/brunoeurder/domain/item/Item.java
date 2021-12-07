package com.switchfully.brunoeurder.domain.item;

import java.util.Objects;
import java.util.UUID;

public class Item {

    private final String itemUniqueID;
    private final String itemName;
    private final String itemDescription;
    private final Double itemPrice;
    private final Integer itemStock;

    public Item(String itemName, String itemDescription, Double itemPrice, Integer itemStock) {
        this.itemUniqueID = UUID.randomUUID().toString();
        this.itemName = Objects.requireNonNull(itemName,"Missing value");
        this.itemDescription = Objects.requireNonNull(itemDescription,"Missing value");
        this.itemPrice = Objects.requireNonNull(itemPrice,"Missing value");
        this.itemStock = Objects.requireNonNull(itemStock,"Missing value");
    }

    public String getItemUniqueID() {
        return itemUniqueID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public Integer getItemStock() {
        return itemStock;
    }

    @Override
    public String toString() {
        return"Record for iem " + getItemUniqueID() +
                ":\n" + "Name: " + getItemName() +
                ":\n" + "Description: " + getItemDescription() +
                ":\n" + "Price: " + getItemPrice() + "€" +
                ":\n" + "Stock: " + getItemStock();
    }
}
