package com.switchfully.brunoeurder.domain.mapper;

import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;
import com.switchfully.brunoeurder.domain.itemGroup.ItemGroupDto;
import org.springframework.stereotype.Component;

@Component
public class ItemGroupMapper {

    public ItemGroupDto mapToItemGroupDto (ItemGroup itemGroup) {
        return new ItemGroupDto()
                .setItemGroupUniqueID(itemGroup.getItemGroupUniqueID())
                .setItem(itemGroup.getItem())
                .setQtyOrdered((itemGroup.getQtyOrdered()))
                .setShippingDate(itemGroup.getShippingDate());
    }

    public ItemGroup mapToItemGroup (ItemGroupDto itemGroupDto) {
        return new ItemGroup(
                itemGroupDto.getItem(),
                itemGroupDto.getQtyOrdered());
    }
}
