package com.switchfully.brunoeurder.service.order;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;
import com.switchfully.brunoeurder.domain.order.Order;
import com.switchfully.brunoeurder.repository.item.ItemRepository;
import com.switchfully.brunoeurder.repository.itemGroup.ItemGroupRepository;
import com.switchfully.brunoeurder.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private final OrderRepository orderRepository;
    private ItemGroupRepository itemGroupRepository;
    private ItemRepository itemRepository;
    private ItemGroup itemGroup;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        orderRepository.add(order);
    }

//    public Double calculatePrice(Order order) {
//        Double totalOrderPrice = 0.0;
//        for (Item item : itemRepository.getItemList()) {
//            totalOrderPrice += item.getItemPrice() * itemGroup.getQtyOrdered();
//        }
//        return totalOrderPrice;
//    }
}
