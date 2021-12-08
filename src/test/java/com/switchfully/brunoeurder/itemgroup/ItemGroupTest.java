package com.switchfully.brunoeurder.itemgroup;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.item.ItemDto;
import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;
import com.switchfully.brunoeurder.domain.itemGroup.ItemGroupDto;
import com.switchfully.brunoeurder.domain.mapper.ItemGroupMapper;
import com.switchfully.brunoeurder.domain.mapper.ItemMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class ItemGroupTest {
    @Test
    void givenItem_when_addingItemToItemGroup_thenItemGroupContainsExactlyItem() {
        //GIVEN
        Item expectedItem = new Item(
                "Rega RP78",
                "Turntable for 78 RPM Records",
                699.0,
                7);
        //WHEN
        ItemGroup actualItemGroup = new ItemGroup(expectedItem, 2);

        String expectedItemUniqueID  = expectedItem.getItemUniqueID();
        String expectedItemName  = expectedItem.getItemName();
        String expectedItemDescription  = expectedItem.getItemDescription();
        Double expectedItemPrice = expectedItem.getItemPrice();
        Integer expectedItemStock  = expectedItem.getItemStock();
        Integer expectedItemQtyOrdered  = 2;
        LocalDate expectedShippingDate = LocalDate.now().plusDays(1);          //Since the item is in stock, the ship date is order date + 1, hence the 1 below

        String actualItemUniqueID  = actualItemGroup.getItem().getItemUniqueID();
        String actualItemName  = actualItemGroup.getItem().getItemName();
        String actualItemDescription  = actualItemGroup.getItem().getItemDescription();
        Double actualItemPrice = actualItemGroup.getItem().getItemPrice();
        Integer actualItemStock = actualItemGroup.getItem().getItemStock();
        Integer actualItemQtyOrdered = actualItemGroup.getQtyOrdered();
        LocalDate actualShippingDate = actualItemGroup.getShippingDate();
        //THEN
        Assertions.assertEquals(actualItemUniqueID,expectedItemUniqueID);
        Assertions.assertEquals(actualItemName,expectedItemName);
        Assertions.assertEquals(actualItemDescription,expectedItemDescription);
        Assertions.assertEquals(actualItemPrice,expectedItemPrice);
        Assertions.assertEquals(actualItemStock,expectedItemStock);
        Assertions.assertEquals(actualItemQtyOrdered,expectedItemQtyOrdered);
        Assertions.assertEquals(actualShippingDate,expectedShippingDate);
    }
}

    /*
    * Story 3: Order items

As a customer I want to order one or more items.

    An Order contains one or more item groups
    An item group contains a selected item (id), an amount, and a shipping date.
        The shipping date should be calculated automatically:
            When we have the item in stock, the shipping date is set to the next day (of the order)
            Otherwise the shipping date should be set to next week (day of order + 7 days)
    The total price should be calculated and shown to the customer when ordering.
    Question: should an order keep a reference to an item or should it make some sort of copy?
        Tip: The the price of the item can change over time... What implications might this have?
    Obviously, we also need to keep track of who made the order (it has to be a known customer)

    * */
