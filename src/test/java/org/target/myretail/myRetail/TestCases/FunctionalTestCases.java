package org.target.myretail.myRetail.TestCases;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.target.myretail.myRetail.request.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FunctionalTestCases {
    
	@Test
	public void GetTheProductForNotExistItem()
	  throws IOException {
	  
	    // Given
	    String name = RandomStringUtils.randomAlphabetic( 8 );
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/product/" + "10000" );
	 
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Then Check the status codes 
	    assertThat(
	      httpResponse.getStatusLine().getStatusCode(),
	      equalTo(404));
	}
	
	@Test
	public void InsertTheKnownItemPriceAndGetTheInfo()
	  throws IOException {
	  
	    // Given
	    String name = "13860428";
	    HttpPut  request = new HttpPut( "http://localhost:8080/product/" + name );
	    ObjectMapper mapper = new ObjectMapper();
	    ProductRequest req= new ProductRequest();
	    req.setCurrencyCode("USD");
	    req.setCurrentPrice(1000.0);
	    String jsonRequest = mapper.writeValueAsString(req);

	    StringEntity entity = new StringEntity(jsonRequest, "UTF-8");
        entity.setContentType("application/json");
	    HttpUriRequest getReq = new HttpGet( "http://localhost:8080/product/" + name );


        request.setEntity(entity);
	    // When
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	    
	    HttpResponse httpResponse1= HttpClientBuilder.create().build().execute( getReq );

	 
	    // Then Check the status codes
	    assertThat(
	      httpResponse.getStatusLine().getStatusCode(),
	      equalTo(201));
	    
	    assertThat(
	  	      httpResponse1.getStatusLine().getStatusCode(),
	  	      equalTo(200));
	}
}

