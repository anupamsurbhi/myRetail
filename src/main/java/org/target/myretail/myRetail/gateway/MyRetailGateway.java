package org.target.myretail.myRetail.gateway;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.target.myretail.myRetail.gateway.exception.ResourceNotFoundException;

@Component
public class MyRetailGateway {
	

	public String getDetail(String id) throws JSONException, ResourceNotFoundException {
		RestTemplate restTemplate = new RestTemplate();
		String result = null;
		String itemDescription = null;
		String url = "https://redsky.target.com/v2/pdp/tcin/" + id;
		try {
			result = restTemplate.getForObject(url, String.class);
			JSONObject obj = new JSONObject(result);
			itemDescription = obj.getJSONObject("product").getJSONObject("item").getJSONObject("product_description")
					.getString("title");
		} catch (Exception e) {
			throw new ResourceNotFoundException("Item Description not found");
		}
		

		return itemDescription;
	}

}