package com.hem.ecom.ProductService.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${product.service.cache.enabled}")
    public boolean productCacheEnabled;

    public boolean isProductCacheEnabled() {
        return productCacheEnabled;
    }

    public void setProductCacheEnabled(boolean productCacheEnabled) {
        this.productCacheEnabled = productCacheEnabled;
    }



}
