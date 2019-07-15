package org.target.myretail.myRetail.request;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@Component
@JsonRootName(value = "ProductRequest")
public class ProductRequest {
	
   	private Double currentPrice;

	private String currencyCode;

}
