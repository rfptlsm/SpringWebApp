package com.springwebapp.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springwebapp.webapp.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
