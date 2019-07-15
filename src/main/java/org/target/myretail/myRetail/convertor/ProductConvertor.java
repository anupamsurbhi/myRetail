package org.target.myretail.myRetail.convertor;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.target.myretail.myRetail.model.Product;
import org.target.myretail.myRetail.documents.ProductData;


@Component
public class ProductConvertor implements Converter<Product, ProductData> {

    @Override
    public ProductData convert(Product product) {
        ProductData productOut = new ProductData();
        if (product.getId() != null  && !StringUtils.isEmpty(product.getId())) {
        	productOut.set_id(new ObjectId(product.getId().toString()));
        }
        productOut.setPrice(BigDecimal.valueOf(product.getCurrentPrice()));
        return productOut;
    }


}
