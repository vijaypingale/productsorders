package com.megamart.productsorders.controller;

import com.megamart.productsorders.entity.Product;
import com.megamart.productsorders.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(@Qualifier("productService") ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    public Product getProductById(Long id) {
        return productService.getProductById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }
}
