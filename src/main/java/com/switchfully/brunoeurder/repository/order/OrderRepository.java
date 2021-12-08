package com.switchfully.brunoeurder.repository.order;

import com.switchfully.brunoeurder.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final List<Order> orderList;

    public OrderRepository() {
        this.orderList = new ArrayList<>();
    }

    public void add (Order order) {
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orderList=" + orderList +
                '}';
    }
}
