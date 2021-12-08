package com.switchfully.brunoeurder.domain.itemGroup;

import com.switchfully.brunoeurder.domain.item.Item;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ItemGroup {

    private final String itemGroupUniqueID;
    private final Item item;
    private final Integer qtyOrdered;
    private LocalDate shippingDate;
    private static final Integer DAYS_FROM_ORDER_TO_SHIP_WHEN_STOCK_AVAILABLE = 1;
    private static final Integer DAYS_FROM_ORDER_TO_SHIP_WHEN_STOCK_OUT = 7;

    public ItemGroup(Item item, Integer qtyOrdered) {
        this.itemGroupUniqueID = UUID.randomUUID().toString();
        this.item = Objects.requireNonNull(item, "Value missing");
        this.qtyOrdered = Objects.requireNonNull(qtyOrdered, "Value missing");
        this.shippingDate = getShippingDate();
    }

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
        if (item.getItemStock() > 0) {
            shippingDate = LocalDate.now().plusDays(DAYS_FROM_ORDER_TO_SHIP_WHEN_STOCK_AVAILABLE);
        } else {
            shippingDate = LocalDate.now().plusDays(DAYS_FROM_ORDER_TO_SHIP_WHEN_STOCK_OUT);
        }
        return shippingDate;
    }

    @Override
    public String toString() {
        return "Record for item group " + getItemGroupUniqueID() +
                ":\n" + "Item: " + getItem().getItemUniqueID() +
                ":\n" + "Quantity ordered: " + getQtyOrdered() +
                ":\n" + "Shipping Date: " + getShippingDate();
    }
}
