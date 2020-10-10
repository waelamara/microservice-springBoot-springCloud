package org.microservice.entities;

import lombok.Data;

@Data
public class Product {
	private String id;
	private String name;
	private float price;
	private Category category;
}
