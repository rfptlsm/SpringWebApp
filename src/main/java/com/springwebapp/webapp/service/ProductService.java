package com.springwebapp.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwebapp.webapp.repositories.ProductRepository;
import com.springwebapp.webapp.dto.ProductDto;
import com.springwebapp.webapp.entites.Product;


@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
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
    public Product save(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryService.findByTitle(productDto.getCategoryTitle()).get());
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
