package org.microservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Data @ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Product {
	@Id
	private String id;
	private String name;
	private float price;
	@DBRef
	private Category category;
	
	
}
