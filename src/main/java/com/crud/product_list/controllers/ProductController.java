package com.crud.product_list.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.product_list.models.ProductModel;
import com.crud.product_list.services.ProductService;

@RestController
@RequestMapping(value = "/", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/get")
    public ArrayList<ProductModel> getProducts() {
        return productService.getProducts();
    }

    @PostMapping(value = "/save", consumes = {"application/json"})
    public ProductModel setProduct(@RequestBody ProductModel product) {
        return this.productService.setProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @DeleteMapping(value = "/delete")
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }
}
