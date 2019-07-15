package org.target.myretail.myRetail.controller;


import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.target.myretail.myRetail.model.Product;
import org.target.myretail.myRetail.request.ProductRequest;
import org.target.myretail.myRetail.response.ProductResponse;
import org.target.myretail.myRetail.service.impl.ProductServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductControllerTest {
    
    @InjectMocks
    ProductController productController = new ProductController();


	@Mock
	Product product;

	@Mock
	ProductResponse productResponse;

	@Mock
	ProductServiceImpl productService;
	


    private final MockMvc mockMvc = standaloneSetup(productController).build();
    private ProductResponse response = new ProductResponse();
    private ObjectMapper mapper;
    private String jsonRequest;
    private String jsonRequestPut;
    
    @Before
    public void setUp() throws Exception {
        initMocks(this);
        
        mapper = new ObjectMapper();

        jsonRequest = mapper.writeValueAsString(null);
        ProductRequest input = new ProductRequest();
        input.setCurrencyCode("USD");
        input.setCurrentPrice(100.00);
        
        jsonRequestPut = mapper.writeValueAsString(input);
    }

    @Test
    public void test() throws Exception {


        String url = String.format("/product/13860428");

        mockMvc.perform(get(url).content(jsonRequest).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
    
    @Test
    public void testFailue() throws Exception {


        String url = String.format("/product/13860428");

        mockMvc.perform(get(url).content(jsonRequest).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
    
    @Test
    public void testPut() throws Exception {


        String url = String.format("/product/1");

        mockMvc.perform(put(url).content(jsonRequestPut).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

    }

    @Test
    public void testPutFailure() throws Exception {


        String url = String.format("/product/");

        mockMvc.perform(put(url).content(jsonRequestPut).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());

    }
}

