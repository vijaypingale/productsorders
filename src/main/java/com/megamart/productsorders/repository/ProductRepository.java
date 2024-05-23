package com.megamart.productsorders.repository;

import com.megamart.productsorders.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
