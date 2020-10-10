package org.microservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ProductItem {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String productId;
	@Transient private Product product;
	private double price;
	private int quantity;
	@ManyToOne
	private Bill bill;
}
