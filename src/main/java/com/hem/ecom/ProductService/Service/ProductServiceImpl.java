package com.hem.ecom.ProductService.Service;

import com.hem.ecom.ProductService.BeanObject.ProductBean;
import com.hem.ecom.ProductService.Controller.ProductServiceController;
import com.hem.ecom.ProductService.DAO.Product;
import com.hem.ecom.ProductService.DAO.ProductRepository;
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

    @Autowired
    public ProductRepository productRepository;

    public void addProduct(ProductBean productBean){
        redisService.save(productBean.getProductId().trim(),productBean.toString());
        try {
            Product product= new Product();
            product.setProductId(productBean.getProductId());
            product.setProductBrand(productBean.getProductBrand());
            product.setProductCategory(productBean.getProductCategory());
            product.setProductName(productBean.getProductName());
            product.setProductDescription(productBean.getProductDescription());
            product.setProductImageUrl(productBean.getProductImageUrl());
            product.setPrimarySku(productBean.getPrimarySku());
            productRepository.save(product);
        }catch (Exception e){
            logger.info("Exception");
        }
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
