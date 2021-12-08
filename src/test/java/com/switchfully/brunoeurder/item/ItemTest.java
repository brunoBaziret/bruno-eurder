package com.switchfully.brunoeurder.item;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.item.ItemDto;
import com.switchfully.brunoeurder.domain.mapper.ItemMapper;
import com.switchfully.brunoeurder.repository.item.ItemRepository;
import com.switchfully.brunoeurder.service.item.ItemService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemTest {
    @Test
    void givenItemInformation_whenCreatingItem_thenItemRepositoryContainsNewItem() {
        //GIVEN
        Item expectedItem = new Item(
                "Rega RP78",
                "Turntable for 78 RPM Records",
                699.0,
                7);
        ItemRepository itemRepository = new ItemRepository();
        ItemService itemService = new ItemService(itemRepository);

        //WHEN
        itemService.addItem(expectedItem);
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
}
