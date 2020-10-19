package org.microservice.service;

import org.microservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT-SERVICE")
public interface IProductService {
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable(name = "id") String id);
}
