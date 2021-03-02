package org.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

//	 @Autowired
//	 private IUserService iUserService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

//	@Bean
//	public void add(){
//		iUserService.saveRole(new AppRole(null,"ADMIN"));
//		iUserService.saveRole(new AppRole(null,"USER"));
//	}

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
