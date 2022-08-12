package com.springwebapp.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwebapp.webapp.repositories.CategoryRepository;
import com.springwebapp.webapp.entites.Category;


@Service
public class CategoryService {
    private CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> getOneById(Long id){
        return categoryRepository.findById(id);
    } 
}
