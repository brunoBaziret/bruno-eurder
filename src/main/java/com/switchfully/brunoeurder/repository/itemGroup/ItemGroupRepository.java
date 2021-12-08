package com.switchfully.brunoeurder.repository.itemGroup;

import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemGroupRepository {
    private final List<ItemGroup> itemGroupList;

    public ItemGroupRepository(List<ItemGroup> itemGroupList) {
        this.itemGroupList = new ArrayList<>();
    }

    public void add(ItemGroup itemGroup) {
        itemGroupList.add(itemGroup);
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    @Override
    public String toString() {
        return "ItemGroupRepository{" +
                "itemGroupList=" + itemGroupList +
                '}';
    }
}
