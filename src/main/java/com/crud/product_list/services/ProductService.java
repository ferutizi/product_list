package com.crud.product_list.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.crud.product_list.models.ProductModel;
import com.crud.product_list.repositories.ProductRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ArrayList<ProductModel> getProducts() {
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel setProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id) {
        return productRepository.findById(id);
    }

    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteAllProducts() {
        try {
            productRepository.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ProductModel> getByPrice(int min, int max) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(ProductModel.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.crud.product_list.models");
        EntityManager entityManager = emf.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ProductModel> criteria = builder.createQuery(ProductModel.class);
        Root<ProductModel> root = criteria.from(ProductModel.class);
        criteria.select(root);

        criteria.where(builder.between(root.get("price"), 10, 20));
        List<ProductModel> products = entityManager.createQuery(criteria).getResultList();

        entityManager.close();
        session.close();
        return products;
    }
}
