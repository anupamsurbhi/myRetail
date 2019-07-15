package org.target.myretail.myRetail.service;

import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.target.myretail.myRetail.gateway.exception.DataNotFoundException;
import org.target.myretail.myRetail.gateway.exception.ResourceNotFoundException;
import org.target.myretail.myRetail.model.Product;
import org.target.myretail.myRetail.response.ProductResponse;;

@Service
public interface ProductService {

	ProductResponse getById(String id) throws JSONException, DataNotFoundException , ResourceNotFoundException;

	ProductResponse saveOrUpdate(Product product);


}
