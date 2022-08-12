package com.springwebapp.webapp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springwebapp.webapp.dto.ProductDto;
import com.springwebapp.webapp.entites.Product;
import com.springwebapp.webapp.exceptions.ResourceNotFoundException;
import com.springwebapp.webapp.exceptions.StoreError;
import com.springwebapp.webapp.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/products")
@Api("Set of endpoints for products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ApiOperation("Returns all products.")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a specific product by their identifier. 404 if does not exist.")
    public ProductDto getProductById(@ApiParam("Id of the product to be obtained. Cannot be empty.") @PathVariable Long id) {
        Product product = productService.getOneById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id));
        return new ProductDto(product);
    }

    @PostMapping
    @ApiOperation("Creates a new product. If id != null, then throw bad request response.")
    public ResponseEntity<?> createNewProduct(@RequestBody Product p) {
        if (p.getId() != null) {
            return new ResponseEntity<>(new StoreError(HttpStatus.BAD_REQUEST.value(),
                    "Id must be null for new entity"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productService.save(p), HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation("Modify product.")
    public ResponseEntity<?> modifyProduct(@RequestBody Product p) {
        if (p.getId() == null) {
            return new ResponseEntity<>(new StoreError(HttpStatus.BAD_REQUEST.value(),
                    "Id must be null for new entity"), HttpStatus.BAD_REQUEST);
        }
        if (!productService.existsById(p.getId())) {
            return new ResponseEntity<>(new StoreError(HttpStatus.BAD_REQUEST.value(),
                    "Product with id: " + p.getId() + " doesn't exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productService.save(p), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete product.")
    public void deleteById(@ApiParam("Id of the product.") @PathVariable Long id) {
        productService.deleteById(id);
    }
}