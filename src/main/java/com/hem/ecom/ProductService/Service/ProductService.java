package com.hem.ecom.ProductService.Service;

import com.hem.ecom.ProductService.BeanObject.ProductBean;

public interface  ProductService {

   public void addProduct(ProductBean productBean);

   public Object getAllProductListFromDB();

   public Object getAllProductListFromCache();

   public void ClearCache();

   public void loadCacheFromDB();

}
