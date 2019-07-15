package org.target.myretail.myRetail.response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Component
@Data
@JsonRootName(value = "current_price")
public class PriceInfo {
	@JsonProperty("value") Double Value;
	@JsonProperty("currency_code")String CurrencyCode;

}
