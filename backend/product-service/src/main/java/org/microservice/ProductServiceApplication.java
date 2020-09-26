package org.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner start(CategoryRepository categoryRepository,ProductRepository productRepository){
//		return args->{
//			categoryRepository.deleteAll();
//			Stream.of("Informatique","Electronique").forEach(ctg->{
//				categoryRepository.save(new Category(null,ctg,new ArrayList<>()));
//			});
//			categoryRepository.findAll().forEach(System.out::println);
//		};
//	}

}
