package com.switchfully.brunoeurder.repository.item;

import com.switchfully.brunoeurder.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "ItemRepository{" +
                "itemList=" + itemList +
                '}';
    }
}
