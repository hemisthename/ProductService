package com.hem.ecom.ProductService.Controller;

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

    @GetMapping("/productList")
    public String productList(){
        logger.info("Starting ProductServiceController :: productList");
        return "hi world";
    }

    @PostMapping ("/addProduct")
    public void addProduct(@RequestBody  String product){
        logger.info("Start ProductServiceController :: addProduct");
        productService.addProduct();
        logger.info("End ProductServiceController :: addProduct");
    }
}
