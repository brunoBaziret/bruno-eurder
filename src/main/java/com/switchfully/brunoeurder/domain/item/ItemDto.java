package com.switchfully.brunoeurder.domain.item;

public class ItemDto {

    private String itemUniqueID;
    private String itemName;
    private String itemDescription;
    private Double itemPrice;
    private Integer itemStock;

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

    public ItemDto setItemUniqueID(String itemUniqueID) {
        this.itemUniqueID = itemUniqueID;
        return this;
    }

    public ItemDto setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public ItemDto setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public ItemDto setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public ItemDto setItemStock(int itemStock) {
        this.itemStock = itemStock;
        return this;
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
