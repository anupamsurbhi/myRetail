package org.target.myretail.myRetail.controller;

import java.io.InvalidClassException;

import javax.validation.constraints.Min;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.target.myretail.myRetail.gateway.exception.DataNotFoundException;
import org.target.myretail.myRetail.gateway.exception.ResourceNotFoundException;
import org.target.myretail.myRetail.model.Product;
import org.target.myretail.myRetail.request.ProductRequest;
import org.target.myretail.myRetail.response.ProductResponse;
import org.target.myretail.myRetail.service.impl.ProductServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("/product")
public class ProductController {

	@Autowired
	Product product;

	@Autowired
	ProductResponse productResponse;

	@Autowired
	ProductServiceImpl productService;

	@ApiOperation(value = "get the product info")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductResponse> getProductDetail(@PathVariable @Min(2) Integer id)
			throws InvalidClassException, JSONException, DataNotFoundException, ResourceNotFoundException {
		ResponseEntity<ProductResponse> result;
		productResponse = productService.getById(id.toString());

		return new ResponseEntity<ProductResponse>(productResponse, null, HttpStatus.OK);

	}

	@ApiOperation(value = "update price")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProductResponse> updatePrice(@PathVariable @Min(2) Integer id,  @RequestBody  ProductRequest productReq)
			throws InvalidClassException {

		product.setCurrentPrice(productReq.getCurrentPrice());
		product.setCurrencyCode(productReq.getCurrencyCode());
		product.setId(id);
		return new ResponseEntity<ProductResponse>(productService.saveOrUpdate(product), null, HttpStatus.CREATED); 
	}

}
