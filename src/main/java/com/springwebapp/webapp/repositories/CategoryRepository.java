package com.springwebapp.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springwebapp.webapp.entites.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    java.util.Optional<Category> findByTitle(String title);
}
