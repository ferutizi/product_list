package com.crud.product_list.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.product_list.models.ProductModel;;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {

}