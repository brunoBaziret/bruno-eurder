package com.switchfully.brunoeurder.api.order;

import com.switchfully.brunoeurder.domain.mapper.OrderMapper;
import com.switchfully.brunoeurder.domain.order.Order;
import com.switchfully.brunoeurder.domain.order.OrderDto;
import com.switchfully.brunoeurder.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="customers/orders")

public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderDto orderDto, @RequestHeader(required = false) String authorization) {
        logger.info("Method 'placeOrder' started");
        Order order = orderMapper.mapToOrder(orderDto);
        orderService.saveOrder(order);
        logger.info("Method 'placeOrder' finished");
    }
}
