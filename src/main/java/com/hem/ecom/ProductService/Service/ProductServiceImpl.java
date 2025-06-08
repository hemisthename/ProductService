package com.hem.ecom.ProductService.Service;

import com.hem.ecom.ProductService.Controller.ProductServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public RedisService redisService;

    public void addProduct(){
        redisService.save("hem","thisismyname");
        logger.info("Start ProductServiceImpl :: addProduct");
    }

    public void getAllProductList(){
      logger.info("All Key "+  redisService.get("hem"));
    }
}
