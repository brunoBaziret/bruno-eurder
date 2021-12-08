package com.switchfully.brunoeurder.service.item;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.item.ItemDto;
import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;
import com.switchfully.brunoeurder.domain.mapper.ItemMapper;
import com.switchfully.brunoeurder.repository.item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {
    @Test
void givenItemInformation_whenSavingItem_thenItemRepositoryContainsNewItem() {
    //GIVEN
    Item expectedItem = new Item(
            "Rega RP78",
            "Turntable for 78 RPM Records",
            699.0,
            7);
    ItemRepository itemRepository = new ItemRepository();
    ItemService itemService = new ItemService(itemRepository);

    //WHEN
    itemService.saveItem(expectedItem);
    List<Item> actualItemList = itemRepository.getItemList();

    //THEN
    Assertions.assertThat(actualItemList.contains(expectedItem));
}

    @Test
    void givenIncompleteItemInformation_whenCreatingNewItem_thenThrowsNullPointerException() {
        //GIVEN Item information with item name missing (null)

        //WHEN, THEN
        Assertions.assertThatThrownBy(() -> {
            ItemDto itemDto = new ItemDto()
                    .setItemName(null)
                    .setItemDescription("Turntable for 78 RPM Records")
                    .setItemPrice(699)
                    .setItemStock(7);
            new ItemMapper().mapToItem(itemDto);
        }).isInstanceOf(NullPointerException.class).hasMessageContaining("Missing value");
    }

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

        String expectedItemUniqueID = expectedItem.getItemUniqueID();
        String expectedItemName = expectedItem.getItemName();
        String expectedItemDescription = expectedItem.getItemDescription();
        Double expectedItemPrice = expectedItem.getItemPrice();
        Integer expectedItemStock = expectedItem.getItemStock();
        Integer expectedItemQtyOrdered = 2;
        LocalDate expectedShippingDate = LocalDate.now().plusDays(1);          //Since the item is in stock, the ship date is order date + 1, hence the 1 below

        String actualItemUniqueID = actualItemGroup.getItem().getItemUniqueID();
        String actualItemName = actualItemGroup.getItem().getItemName();
        String actualItemDescription = actualItemGroup.getItem().getItemDescription();
        Double actualItemPrice = actualItemGroup.getItem().getItemPrice();
        Integer actualItemStock = actualItemGroup.getItem().getItemStock();
        Integer actualItemQtyOrdered = actualItemGroup.getQtyOrdered();
        LocalDate actualShippingDate = actualItemGroup.getShippingDate();
        //THEN
        org.junit.jupiter.api.Assertions.assertEquals(actualItemUniqueID, expectedItemUniqueID);
        org.junit.jupiter.api.Assertions.assertEquals(actualItemName, expectedItemName);
        org.junit.jupiter.api.Assertions.assertEquals(actualItemDescription, expectedItemDescription);
        org.junit.jupiter.api.Assertions.assertEquals(actualItemPrice, expectedItemPrice);
        org.junit.jupiter.api.Assertions.assertEquals(actualItemStock, expectedItemStock);
        org.junit.jupiter.api.Assertions.assertEquals(actualItemQtyOrdered, expectedItemQtyOrdered);
        org.junit.jupiter.api.Assertions.assertEquals(actualShippingDate, expectedShippingDate);
    }
}