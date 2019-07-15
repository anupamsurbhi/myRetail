package org.target.myretail.myRetail.response;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.target.myretail.myRetail.error.MyRetailError;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@Component
@Scope("prototype")
@JsonRootName(value = "ProductResponse")
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"id" , "name" ,"current_price"})
public class ProductResponse {
	 
	@JsonProperty("id") private Integer Id ;
	@JsonProperty("name") private String Name;
	private Double currentPrice;
	private PriceInfo current_price;
	private MyRetailError error;

	public void addError(MyRetailError toAdd) {
		this.error = toAdd;
	}
}