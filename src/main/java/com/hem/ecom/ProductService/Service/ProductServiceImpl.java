package com.hem.ecom.ProductService.Service;

import com.hem.ecom.ProductService.Controller.ProductServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    public void addProduct(){
        logger.info("Start ProductServiceImpl :: addProduct");
    }
}
