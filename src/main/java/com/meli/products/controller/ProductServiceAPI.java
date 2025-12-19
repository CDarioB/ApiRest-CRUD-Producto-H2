package com.meli.products.controller;

import com.meli.products.model.Product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
public interface ProductServiceAPI {

    @GetMapping
    List<Product> getAllProducts();

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Product> create(@RequestBody @Valid Product product);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
