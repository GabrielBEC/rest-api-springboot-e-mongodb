package com.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

}
