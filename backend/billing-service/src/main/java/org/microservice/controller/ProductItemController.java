package org.microservice.controller;

import java.util.Collection;

import org.microservice.entities.ProductItem;
import org.microservice.service.IBillService;
import org.microservice.service.IProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductItemController {

	@Autowired
	IProductItemService iProductItemService;
	@Autowired
	IBillService iBillService;
	
	 @GetMapping("/productItems")
	 public Collection<ProductItem> findAll(){
		return iProductItemService.findAll();
	 }
	 
	 @PostMapping("/addproductItem")
	 public ProductItem AddProductItem(@RequestBody ProductItem productItem){
		return iProductItemService.save(productItem);
	 }
	 
	 @DeleteMapping("/deleteProductItem/{id}")
	 public void deleteBill(@PathVariable(name="id") Long id){
		 iProductItemService.removeByid(id);
	 }
}
