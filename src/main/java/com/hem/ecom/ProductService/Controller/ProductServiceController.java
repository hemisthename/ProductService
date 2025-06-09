package com.hem.ecom.ProductService.Controller;

import com.hem.ecom.ProductService.BeanObject.ProductBean;
import com.hem.ecom.ProductService.Config.AppConfig;
import com.hem.ecom.ProductService.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);


    @Autowired
    public ProductService productService;

    @Autowired
    public AppConfig appConfig;

    @GetMapping("/productListfromDB")
    public Object productListFromDB(){
        logger.info("Starting ProductServiceController :: productList");
        logger.info("Application Properties :: {}",appConfig.isProductCacheEnabled());
        return  productService.getAllProductListFromDB();

    }


    @GetMapping("/productListfromCache")
    public Object productListfromCache(){
        logger.info("Starting ProductServiceController :: productList");
        Object prdFromCache =productService.getAllProductListFromCache();
        return  productService.getAllProductListFromCache();

    }

    @PostMapping ("/addProduct")
    public void addProduct(@RequestBody ProductBean product){
        logger.info("Start ProductServiceController :: addProduct");
        productService.addProduct(product);
        logger.info("End ProductServiceController :: addProduct");
    }

    @GetMapping ("/loadCache")
    public void loadProductstoCache(){

        productService.loadCacheFromDB();
    }

    @GetMapping ("/clearCache")
    public void clearCache(){

        productService.ClearCache();
    }



}
