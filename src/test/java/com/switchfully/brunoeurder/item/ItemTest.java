package com.switchfully.brunoeurder.item;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.item.ItemDto;
import com.switchfully.brunoeurder.domain.mapper.ItemMapper;
import com.switchfully.brunoeurder.repository.item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemTest {
    @Test
    void givenItemInformation_whenCreatingNewItemAndAddingItToItemRepository_thenItemRepositoryContainsNewItem() {
        //GIVEN
        //Item information = Rega Rp78, Turntable for 78 RPM Records, 699,-EUR, 7 pieces

        //WHEN
        ItemDto itemDto= new ItemDto()
                .setItemName("Rega RP78")
                .setItemDescription("Turntable for 78 RPM Records")
                .setItemPrice(699)
                .setItemStock(7);
        Item expected = new ItemMapper().mapToItem(itemDto);
        ItemRepository actual = new ItemRepository();
        actual.add(expected);
        System.out.println(actual);

        //THEN
        Assertions.assertThat(actual.getItemList()).containsExactly(expected);
    }

    @Test
    void givenIncompleteItemInformation_whenCreatingNewItem_thenThrowsNullPointerException() {
        //GIVEN Item information with item name missing (null)

        //WHEN, THEN
        Assertions.assertThatThrownBy(() -> {
            ItemDto itemDto= new ItemDto()
                    .setItemName(null)
                    .setItemDescription("Turntable for 78 RPM Records")
                    .setItemPrice(699)
                    .setItemStock(7);
            new ItemMapper().mapToItem(itemDto);
        }).isInstanceOf(NullPointerException.class).hasMessageContaining("Missing value");
    }
}
