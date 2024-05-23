package com.megamart.productsorders.controller;

import com.megamart.productsorders.entity.Order;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public interface OrderController {

    @GetMapping
    List<Order> getAllOrders();

    @GetMapping("/{id}")
    Order getOrderById(@PathVariable Long id);

    @PostMapping
    Order createOrder(@RequestBody Order order);

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Long id);
}
