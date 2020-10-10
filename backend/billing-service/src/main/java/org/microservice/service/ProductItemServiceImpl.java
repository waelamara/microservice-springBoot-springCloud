package org.microservice.service;

import java.util.Collection;

import org.microservice.dao.ProductItemRepository;
import org.microservice.entities.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductItemServiceImpl implements IProductItemService {

	@Autowired
	ProductItemRepository productItemRepository;
	@Autowired
	IUserService iUserService;
	@Autowired
	IProductService iProductService;
	
	@Override
	public Collection<ProductItem> findAll() {
		Collection<ProductItem> productItems=productItemRepository.findAll();
		 for (ProductItem p : productItems) {
			 p.setProduct(iProductService.findProductById(p.getProductId()));
			 p.getBill().setUser(iUserService.findUserById(p.getBill().getUserId()));
		}
		return productItems;
	}
	
	@Override
	public ProductItem findById(Long id) {
		return productItemRepository.getOne(id);
	}

	@Override
	public ProductItem save(ProductItem productItem) {
		return productItemRepository.save(productItem);
	}

	@Override
	public void removeByid(Long id) {
		productItemRepository.deleteById(id);
	}

	@Override
	public ProductItem UpdateProduit(ProductItem productItem) {
		return productItemRepository.save(productItem);
	}



}
