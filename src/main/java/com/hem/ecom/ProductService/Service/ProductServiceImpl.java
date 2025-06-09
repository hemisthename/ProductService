package com.hem.ecom.ProductService.Service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hem.ecom.ProductService.BeanObject.ProductBean;
import com.hem.ecom.ProductService.Controller.ProductServiceController;
import com.hem.ecom.ProductService.DAO.Product;
import com.hem.ecom.ProductService.DAO.ProductList;
import com.hem.ecom.ProductService.DAO.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public RedisService redisService;

    @Autowired
    public ProductRepository productRepository;

    public void addProduct(ProductBean productBean){
        Product product= new Product();
        try {

            product.setProductId(productBean.getProductId());
            product.setProductBrand(productBean.getProductBrand());
            product.setProductCategory(productBean.getProductCategory());
            product.setProductName(productBean.getProductName());
            product.setProductDescription(productBean.getProductDescription());
            product.setProductImageUrl(productBean.getProductImageUrl());
            product.setPrimarySku(productBean.getPrimarySku());
            productRepository.save(product);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(product);

            redisService.save(productBean.getProductId().trim(),json);
        }catch (Exception e){
            logger.info("Exception");
        }
        logger.info("Start ProductServiceImpl :: addProduct");
    }

    public Object getAllProductListFromDB(){
       List<Product> productList = productRepository.findAll();
        ProductList prdList = new ProductList();
        prdList.setProductList(productList);
        return prdList;
    }

    public Object loadCacheFromDB(){
        List<Product> productList = productRepository.findAll();
        try {
            for (Product prd : productList) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json =objectMapper.writeValueAsString(prd);
                redisService.save(prd.getProductId(),json);
            }
        }catch (Exception e){
            logger.info("Exception in log {}",e.getMessage());
        }
        return null;
    }

    public void ClearCache(){
        Set<String> getallKeys = redisService.getAllKeys();
        if(null !=getallKeys) {
            for (String key : getallKeys) {
                Product prd = new Product();
                logger.info("Redis Key: {}", key);
                redisService.deleteKey(key);
            }
        }
    }


    public Object getAllProductListFromCache(){
         Set<String> getallKeys = redisService.getAllKeys();
        ProductList prdList = new ProductList();
        List<Product> prdList1 = new ArrayList<>();
    try {
    if (getallKeys != null) {
        for (String key : getallKeys) {
            Product prd = new Product();
            logger.info("Redis Key: " + key);
            logger.info("REDIS VALUE " + redisService.get(key));
            ObjectMapper objectMapper = new ObjectMapper();
            prd = objectMapper.readValue(redisService.get(key), Product.class);
            prdList1.add(prd);


        }
        prdList.setProductList(prdList1);
    }
    return  prdList;
}catch (Exception e){
        logger.info("Exception in log {}",e.getMessage());

    }
    return null;
    }
}
