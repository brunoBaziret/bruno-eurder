package com.switchfully.brunoeurder.service.item;


import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
