package com.sop.chapter7.productservice.query;

import com.sop.chapter7.productservice.core.ProductEntity;
import com.sop.chapter7.productservice.core.data.ProductRepository;
import com.sop.chapter7.productservice.core.event.ProductCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;

public class ProductEventsHandler {
    private final ProductRepository productRepository;

    public  ProductEventsHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreateEvent event){

        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }

}
