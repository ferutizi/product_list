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

import com.crud.product_list.models.ProductsModel;
import com.crud.product_list.services.ProductsService;

@RestController
@RequestMapping(value = "/", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping("/get")
    public ArrayList<ProductsModel> getProducts() {
        return productsService.getProducts();
    }

    @PostMapping(value = "/save", consumes = {"application/json"})
    public ProductsModel setProduct(@RequestBody ProductsModel product) {
        return this.productsService.setProduct(product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productsService.deleteProduct(id);
    }

    @DeleteMapping(value = "/delete")
    public void deleteAllProducts() {
        productsService.deleteAllProducts();
    }
}
