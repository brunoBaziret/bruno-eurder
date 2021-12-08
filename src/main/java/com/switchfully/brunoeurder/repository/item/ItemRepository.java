package com.switchfully.brunoeurder.repository.item;

import com.switchfully.brunoeurder.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ItemRepository {

    private final List<Item> itemList;

    public ItemRepository() {
        this.itemList = new ArrayList<>();
    }

    public void add (Item item) {
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public Item getItemById(String id) {
        for (Item item : itemList) {
            if (item.getItemUniqueID().equals(id)) {
                return item;
            }
        }
        throw new NoSuchElementException("Item not found");
    }

    @Override
    public String toString() {
        return "ItemRepository{" +
                "itemList=" + itemList +
                '}';
    }
}
