package com.switchfully.brunoeurder.domain.mapper;

import com.switchfully.brunoeurder.domain.order.Order;
import com.switchfully.brunoeurder.domain.order.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto()
                .setOrderUniqueID(order.getOrderUniqueID())
                .setItemGroup(order.getItemGroup());
    }

    public Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getItemGroup(),
                orderDto.getOrderPrice());
    }
}
