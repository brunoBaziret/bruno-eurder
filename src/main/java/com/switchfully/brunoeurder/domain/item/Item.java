package com.switchfully.brunoeurder.domain.item;

import java.util.Objects;
import java.util.UUID;

public class Item {

    private final String itemUniqueID;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    private Integer itemStock;

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

    public Item setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Item setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public Item setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public Item setItemStock(Integer itemStock) {
        this.itemStock = itemStock;
        return this;
    }

    @Override
    public String toString() {
        return"Record for item " + getItemUniqueID() +
                ":\n" + "Name: " + getItemName() +
                ":\n" + "Description: " + getItemDescription() +
                ":\n" + "Price: " + getItemPrice() + "€" +
                ":\n" + "Stock: " + getItemStock();
    }
}
