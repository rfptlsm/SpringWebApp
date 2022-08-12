package com.springwebapp.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwebapp.webapp.repositories.ProductRepository;
import com.springwebapp.webapp.entites.Product;


@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void ProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // public List<Product> getAllProducts(){
    //     return productRepository.findAll();
    // }
    public List<Product>getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getOneById(Long id){
        return productRepository.findById(id);
    }

    public boolean existsById(Long id){
        return productRepository.existsById(id); 
    }

    // Save Product
    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
