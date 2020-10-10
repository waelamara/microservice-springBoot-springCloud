package org.microservice.service;

import java.util.Collection;

import org.microservice.entities.ProductItem;

public interface IProductItemService {
	public Collection<ProductItem> findAll();
	public ProductItem findById(Long id);
	public ProductItem save(ProductItem bill);
	public void removeByid(Long id);
	public ProductItem UpdateProduit(ProductItem bill);
}
