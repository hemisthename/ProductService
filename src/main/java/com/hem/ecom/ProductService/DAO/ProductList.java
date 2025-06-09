package com.hem.ecom.ProductService.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductList {

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    @JsonProperty("Product")
    public List<Product> productList;
}
