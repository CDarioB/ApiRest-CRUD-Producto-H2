package com.meli.products.controller;

import com.meli.products.model.Product;
import com.meli.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController implements ProductServiceAPI {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    // GET /api/products
    // Devuelve la lista completa de productos
    @Override
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    // GET /api/products/{id}
    // Devuelve un producto específico
    @Override
    public Product getProductById(Long id) {
        return service.findById(id);
    }

    @Override
    public ResponseEntity<Product> create(Product product){
        Product saved = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
