package org.target.myretail.myRetail.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.target.myretail.myRetail.error.MyRetailError;
import org.target.myretail.myRetail.model.Product;
import org.target.myretail.myRetail.response.PriceInfo;
import org.target.myretail.myRetail.response.ProductResponse;

@Component
public class RequestValidator {

	@Autowired
	Product product;

	@Autowired
	ProductResponse productResponse ;

	@Autowired
	PriceInfo priceInfo;

	@Autowired
	MyRetailError error;
	
	
	

	public ResponseEntity<ProductResponse> CheckInput(Integer item, String currency, Double value) {
		HttpStatus status;
		productResponse = new ProductResponse();
		if (!currency.equals("USD") || value <= 0.0) {
			error.setMessage(("Currency shhould be USD and price should be greater then zero"));
			productResponse.setError(error);
			status = HttpStatus.BAD_REQUEST;
			
		} else {
			productResponse.setId(item);
			priceInfo.setCurrencyCode(currency);
			priceInfo.setValue(value);
			productResponse.setCurrent_price(priceInfo);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<ProductResponse>(productResponse, null, status );

	}
}
