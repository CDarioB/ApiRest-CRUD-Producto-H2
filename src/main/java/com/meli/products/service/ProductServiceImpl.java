package com.meli.products.service;

import com.meli.products.exception.NoSuchResourceFoundException;
import com.meli.products.model.Product;
import com.meli.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    private final ProductRepository repository;


    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    // Obtener todos los productos
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }


    // Obtener producto por ID
    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchResourceFoundException("Producto no encontrado con id: " + id));
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchResourceFoundException("Producto no encontrado con id " + id);
        }
        repository.deleteById(id);
    }
}
