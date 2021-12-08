package com.switchfully.brunoeurder.service.item;


import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItem(Item item) {
        itemRepository.add(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.getItemList();
    }

    public Item getItem(String itemUniqueID) {
        for (Item item : itemRepository.getItemList()) {
            if (item.getItemUniqueID().equals(itemUniqueID)) {
                return item;
            }
        }
        throw new NoSuchElementException("ERROR - Item not found");
    }
}
