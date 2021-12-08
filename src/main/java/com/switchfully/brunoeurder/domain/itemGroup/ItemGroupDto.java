package com.switchfully.brunoeurder.domain.itemGroup;

import com.switchfully.brunoeurder.domain.item.Item;

import java.time.LocalDate;

public class ItemGroupDto {

    private String itemGroupUniqueID;
    private Item item;
    private Integer qtyOrdered;
    private LocalDate shippingDate;


    public String getItemGroupUniqueID() {
        return itemGroupUniqueID;
    }

    public Item getItem() {
        return item;
    }

    public Integer getQtyOrdered() {
        return qtyOrdered;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public ItemGroupDto setItemGroupUniqueID(String itemGroupUniqueID) {
        this.itemGroupUniqueID = itemGroupUniqueID;
        return this;
    }

    public ItemGroupDto setItem(Item item) {
        this.item = item;
        return this;
    }

    public ItemGroupDto setQtyOrdered(Integer qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
        return this;
    }

    public ItemGroupDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    @Override
    public String toString() {
        return "Record for item group " + getItemGroupUniqueID() +
                ":\n" + "Item: " + getItem().getItemUniqueID() +
                ":\n" + "Quantity ordered: " + getQtyOrdered() +
                ":\n" + "Shipping Date: " + getShippingDate();
    }
}
