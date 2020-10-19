package org.microservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @ToString  @NoArgsConstructor @AllArgsConstructor 
public class Product {
	@Id
	private String id;
	private String name;
	private float price;
	@DBRef
	private Category category;
	
	
}
