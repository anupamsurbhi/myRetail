package org.target.myretail.myRetail.service.impl;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.target.myretail.myRetail.gateway.MyRetailGateway;
import org.target.myretail.myRetail.gateway.exception.DataNotFoundException;
import org.target.myretail.myRetail.gateway.exception.MyRetailExceptionHandler;
import org.target.myretail.myRetail.gateway.exception.ResourceNotFoundException;
import org.target.myretail.myRetail.documents.ProductData;
import org.target.myretail.myRetail.model.Product;
import org.target.myretail.myRetail.repository.ProductRepository;
import org.target.myretail.myRetail.response.PriceInfo;
import org.target.myretail.myRetail.response.ProductResponse;
import org.target.myretail.myRetail.service.ProductService;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	ProductData productData;

	@Autowired
	Product product;

	@Autowired
	ProductResponse productResponse;

	@Autowired
	PriceInfo priceInfo;

	@Autowired
	MyRetailExceptionHandler myRetailExceptionHandler;

	@Autowired
	MyRetailGateway myRetailGateway;

	@Autowired
	private MessageSource messageSource;

	@Override
	public ProductResponse getById(String id) throws JSONException, DataNotFoundException, ResourceNotFoundException {
		try {
			product = productRepository.findById(Integer.valueOf(id));
			if (product == null) {
				throw new DataNotFoundException();
			}
			productResponse.setName(myRetailGateway.getDetail(id));
		} catch (ResourceNotFoundException e) {
			log.error("Create resource not found - Unable to get product description");
			throw new ResourceNotFoundException();
		} catch (DataNotFoundException e) {
			log.error("Create Data not found exception");
			throw new DataNotFoundException();
		} catch (Exception e) {
			log.error("exception" + e);

		}

		return productResponse;
	}

	@Override
	public ProductResponse saveOrUpdate(Product product) {
		try {
			productRepository.save(product);
		} catch (Exception e) {
			log.error("Unable to Update/Insert into Mongo DB");
		}
		priceInfo.setCurrencyCode(product.getCurrencyCode());
		priceInfo.setValue(product.getCurrentPrice());
		productResponse.setCurrent_price(priceInfo);
		productResponse.setId(product.getId());
		productResponse.setName(null);
		return productResponse;
	}

}
