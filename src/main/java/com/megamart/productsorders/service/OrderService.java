package com.megamart.productsorders.service;

import com.megamart.productsorders.entity.Order;
import com.megamart.productsorders.entity.Product;
import com.megamart.productsorders.repository.OrderRepository;
import com.megamart.productsorders.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("orderService")
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order createOrder(Order order) {
        List<Product> managedProducts = new ArrayList<>();
        for (Product product : order.getProducts()) {
            if (product.getId() != null) {
                System.out.println("Adding product:= "+ product.getName());
                Product managedProduct = productRepository.findById(product.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + product.getId()));
                managedProducts.add(managedProduct);
            }
            else {
                managedProducts.add(product);
            }
        }
        order.setProducts(managedProducts);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
