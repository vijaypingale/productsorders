package com.megamart.productsorders.repository;

import com.megamart.productsorders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
