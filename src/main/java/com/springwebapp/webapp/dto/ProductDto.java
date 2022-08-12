package com.springwebapp.webapp.dto;

import com.springwebapp.webapp.entites.Product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "Product dto in the application.")
public class ProductDto {
    
    @ApiModelProperty(notes = "Unique identifier of the product. No two products can have the same id",
                                example = "1", required = true, position = 0)
    private Long id;
    
    @ApiModelProperty(notes = "Title of the product",
                                example = "Coca-Cola", required = true, position = 1)
    private String title;
    
    @ApiModelProperty(notes = "Price of the product",
                                example = "100", required = true, position = 2)
    private int price;

    @ApiModelProperty(notes = "Category title of the product",
                                example = "Food", required = true, position = 3)
    private String categoryTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoryTitle = product.getCategory().getTitle();
    }
}
