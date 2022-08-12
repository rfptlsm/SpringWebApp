package com.springwebapp.webapp.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.springwebapp.webapp.entites.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class  CategoryDto {

    private Long id;
    private String title;
    private List<ProductDto> products;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.products = category.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }

}
