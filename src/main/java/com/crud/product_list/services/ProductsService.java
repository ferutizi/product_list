package com.crud.product_list.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.product_list.models.ProductsModel;
import com.crud.product_list.repositories.ProductsRepository;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    public ArrayList<ProductsModel> getProducts() {
        return (ArrayList<ProductsModel>) productsRepository.findAll();
    }

    public ProductsModel setProduct(ProductsModel product) {
        return productsRepository.save(product);
    }

    public Optional<ProductsModel> getById(Long id) {
        return productsRepository.findById(id);
    }

    public boolean deleteProduct(Long id) {
        try {
            productsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteAllProducts() {
        try {
            productsRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
