package com.hem.ecom.ProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "com.hem.ecom.*")
@EntityScan(basePackages = "com.hem.ecom.ProductService.DAO")
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
