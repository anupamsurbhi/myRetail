package org.target.myretail.myRetail.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.target.myretail.myRetail.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	Product findById (Integer Id);

}
