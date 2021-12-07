package com.switchfully.brunoeurder.api.item;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.item.ItemDto;
import com.switchfully.brunoeurder.domain.mapper.ItemMapper;
import com.switchfully.brunoeurder.service.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")

public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody ItemDto itemDto, @RequestHeader(required = false) String authorization) {
        logger.info("Method 'addItem' started");
        Item item = itemMapper.mapToItem(itemDto);
        itemService.addItem(item);
        logger.info("Method 'addItem' finished");
    }
}
