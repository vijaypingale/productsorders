package com.megamart.productsorders.controller;

import com.megamart.productsorders.entity.Product;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public interface ProductController {

    @GetMapping
    List<Product> getAllProducts();

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Long id);

    @PostMapping
    Product createProduct(@RequestBody Product product);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id);
}
