package org.target.myretail.myRetail.documents;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Document
@Component
public class ProductData {
	  	@Id
	    private ObjectId _id;
	    private BigDecimal price;
	    private String imageUrl;

}
