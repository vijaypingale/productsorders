package com.megamart.productsorders.controller;

import com.megamart.productsorders.entity.Order;
import com.megamart.productsorders.service.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    public OrderControllerImpl(@Qualifier("orderService") OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderService.getOrderById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderService.createOrder(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }
}