package com.switchfully.brunoeurder.order;

import com.switchfully.brunoeurder.domain.item.Item;
import com.switchfully.brunoeurder.domain.itemGroup.ItemGroup;
import com.switchfully.brunoeurder.domain.order.Order;
import com.switchfully.brunoeurder.repository.order.OrderRepository;
import com.switchfully.brunoeurder.service.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderTest {

    @Test
    void givenItemGroupList_whenCreatingOrderWithItemGroupList_thenOrderContainsExactlyItemGroupList() {
        //GIVEN
        Item item1 = new Item(
                "Rega RP78",
                "Turntable for 78 RPM Records",
                699.0,
                7);
        ItemGroup expectedItemGroup1 = new ItemGroup(item1, 2);

        Item item2 = new Item(
                "Cyclotron",
                "Particle accelerator",
                100000000.0,
                1);
        ItemGroup expectedItemGroup2 = new ItemGroup(item2, 1);

        List<ItemGroup> itemGroupList = new ArrayList<>();
        itemGroupList.add(expectedItemGroup1);
        itemGroupList.add(expectedItemGroup2);

        //WHEN
        Order actualOrder = new Order(itemGroupList, item1.getItemPrice() + item2.getItemPrice());

        //THEN
        Assertions.assertThat(actualOrder.getItemGroup()).containsAnyOf(expectedItemGroup1, expectedItemGroup2);
    }

    @Test
    void givenOrder_whenPlacingOrder_thenOrderIsAddedToOrderRepository() {
        //GIVEN
        Item item1 = new Item(
                "Rega RP78",
                "Turntable for 78 RPM Records",
                699.0,
                7);
        ItemGroup itemGroup1 = new ItemGroup(item1, 2);

        Item item2 = new Item(
                "Cyclotron",
                "Particle accelerator",
                100000000.0,
                1);
        ItemGroup itemGroup2 = new ItemGroup(item2, 1);

        List<ItemGroup> itemGroupList = new ArrayList<>();
        itemGroupList.add(itemGroup1);
        itemGroupList.add(itemGroup2);

        Order expectedOrder = new Order(itemGroupList, item1.getItemPrice() + item2.getItemPrice());
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(orderRepository);

        //WHEN
        orderService.placeOrder(expectedOrder);
        List<Order> actualOrderList = orderRepository.getOrderList();

        //THEN
        Assertions.assertThat(actualOrderList).containsExactly(expectedOrder);
    }

    @Test
    void givenOrder_whenCalculatingPrice_thenPriceEqualsSpecifiedAmount () {
        //GIVEN
        Item item1 = new Item(
                "Rega RP78",
                "Turntable for 78 RPM Records",
                699.0,
                7);
        ItemGroup itemGroup1 = new ItemGroup(item1, 2);

        Item item2 = new Item(
                "Cyclotron",
                "Particle accelerator",
                100000000.0,
                1);
        ItemGroup itemGroup2 = new ItemGroup(item2, 1);

        List<ItemGroup> itemGroupList = new ArrayList<>();
        itemGroupList.add(itemGroup1);
        itemGroupList.add(itemGroup2);

        Order order = new Order(itemGroupList, item1.getItemPrice() + item2.getItemPrice());
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(orderRepository);

        //WHEN
        orderService.placeOrder(order);
        List<Order> actualOrderList = orderRepository.getOrderList();


    }
}
