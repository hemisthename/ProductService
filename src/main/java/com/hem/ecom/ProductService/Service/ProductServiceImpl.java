package com.hem.ecom.ProductService.Service;

import com.hem.ecom.ProductService.BeanObject.ProductBean;
import com.hem.ecom.ProductService.Controller.ProductServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public RedisService redisService;

    public void addProduct(ProductBean productBean){
        redisService.save(productBean.getProductId().trim(),productBean.toString());
        logger.info("Start ProductServiceImpl :: addProduct");
    }

    public void getAllProductList(){
      Set<String> getallKeys = redisService.getAllKeys();

        if (getallKeys != null) {
            for (String key : getallKeys) {
                logger.info("Redis Key: " + key);
                logger.info("REDIS VALUE "+redisService.get(key));
            }
        }
    }
}
