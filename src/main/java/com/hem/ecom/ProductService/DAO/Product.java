package com.hem.ecom.ProductService.DAO;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "productId")
    private String productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productImageUrl")
    private String productImageUrl;
    @Column(name = "productBrand")
    private String productBrand;
    @Column(name = "productCategory")
    private String productCategory;
    @Column(name = "primarySku")
    private String primarySku;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getPrimarySku() {
        return primarySku;
    }

    public void setPrimarySku(String primarySku) {
        this.primarySku = primarySku;
    }
    @PostConstruct
    public void debugLoad() {
        System.out.println(" Product entity loaded and used by Hibernate");
    }

    // Getters & setters
}
