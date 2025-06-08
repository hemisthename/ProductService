
package com.hem.ecom.ProductService.BeanObject;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productId",
    "productName",
    "productDescription",
    "productImageUrl",
    "productBrand",
    "productCategory",
    "primarySku"
})
@Generated("jsonschema2pojo")
public class ProductBean {



    @JsonProperty("productId")
    private String productId;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("productDescription")
    private String productDescription;
    @JsonProperty("productImageUrl")
    private String productImageUrl;
    @JsonProperty("productBrand")
    private String productBrand;
    @JsonProperty("productCategory")
    private String productCategory;
    @JsonProperty("primarySku")
    private String primarySku;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("productDescription")
    public String getProductDescription() {
        return productDescription;
    }

    @JsonProperty("productDescription")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @JsonProperty("productImageUrl")
    public String getProductImageUrl() {
        return productImageUrl;
    }

    @JsonProperty("productImageUrl")
    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    @JsonProperty("productBrand")
    public String getProductBrand() {
        return productBrand;
    }

    @JsonProperty("productBrand")
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    @JsonProperty("productCategory")
    public String getProductCategory() {
        return productCategory;
    }

    @JsonProperty("productCategory")
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @JsonProperty("primarySku")
    public String getPrimarySku() {
        return primarySku;
    }

    @JsonProperty("primarySku")
    public void setPrimarySku(String primarySku) {
        this.primarySku = primarySku;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", primarySku='" + primarySku + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

}
