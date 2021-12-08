package com.switchfully.brunoeurder.api.item;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.item.ItemDto;
import com.switchfully.brunoeurder.domain.mapper.ItemMapper;
import com.switchfully.brunoeurder.repository.item.ItemRepository;
import com.switchfully.brunoeurder.service.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/items")

public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private ItemRepository itemRepository;
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemService itemService, ItemMapper itemMapper, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody ItemDto itemDto, @RequestHeader(required = false) String authorization) {
        logger.info("Method 'addItem' started");
        Item item = itemMapper.mapToItem(itemDto);
        itemService.saveItem(item);
        logger.info("Method 'addItem' finished");
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems(@RequestHeader(required = false) String authorization) {
        logger.info("Method 'getAllItems' started");
        List<Item> itemList = itemService.getAllItems();
        List<ItemDto> itemDtoList = itemList.stream()
                .map(itemMapper::mapToItemDto)
                .collect(Collectors.toList());

        logger.info("Method 'getAllItems' finished");
        return itemDtoList;
    }

    @GetMapping(path = "{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto getItem(@PathVariable("id") String id, @RequestHeader(required = false) String authorization) {
        logger.info("Method 'getItem' started");
        Item item = itemService.getItem(id);
        ItemDto itemDto = itemMapper.mapToItemDto(item);
        logger.info("Method 'getItem' finished");
        return itemDto;
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto updateItem(@PathVariable("id") String id, @RequestBody ItemDto itemDtoNew, @RequestHeader(required = false) String authorization) {
        logger.info("Method 'updateItem' started");
        Item item = itemRepository.getItemById(id);
        Item newItem = itemMapper.mapToItem(itemDtoNew);
        item.setItemName(newItem.getItemName())
                .setItemDescription(newItem.getItemDescription())
                .setItemPrice(newItem.getItemPrice())
                .setItemStock(newItem.getItemStock());
        ItemDto itemDtoUpdated = itemMapper.mapToItemDto(item);
        logger.info("Method 'updateItem' finished");
        return itemDtoUpdated;
    }
}
