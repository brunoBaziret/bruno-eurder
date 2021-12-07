package com.switchfully.brunoeurder.domain.mapper;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.item.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto mapToItemDto (Item item) {
        return new ItemDto()
                .setItemUniqueID(item.getItemUniqueID())
                .setItemName(item.getItemName())
                .setItemDescription(item.getItemDescription())
                .setItemPrice(item.getItemPrice())
                .setItemStock(item.getItemStock());
    }

    public Item mapToItem (ItemDto itemDto) {
        return new Item(
                itemDto.getItemName(),
                itemDto.getItemDescription(),
                itemDto.getItemPrice(),
                itemDto.getItemStock());
    }
}
