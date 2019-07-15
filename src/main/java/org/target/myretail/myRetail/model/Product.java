package org.target.myretail.myRetail.model;



import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@Document(collection="Product")
public class Product {
	

	@org.springframework.data.annotation.Id
	private Integer id ;
	private Double currentPrice;
	private String currencyCode;

}