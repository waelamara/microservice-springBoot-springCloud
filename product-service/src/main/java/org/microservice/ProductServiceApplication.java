package org.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
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
