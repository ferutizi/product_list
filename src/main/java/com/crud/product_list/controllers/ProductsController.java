package com.crud.product_list.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductsController {
    
    @GetMapping("/")
    public String hola() {
        return "hola";
    }
}
