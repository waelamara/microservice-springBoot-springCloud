package org.microservice.securityservice;

import org.microservice.securityservice.entities.AppRole;
import org.microservice.securityservice.entities.AppUser;
import org.microservice.securityservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"CUSTOMER_MANAGER"));
            accountService.addNewRole(new AppRole(null,"PRODUCT_MANAGER"));
            accountService.addNewRole(new AppRole(null,"BILLS_MANAGER"));

            accountService.addNewUser(new AppUser(null,"Admin","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"User1","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"User2","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"User3","1234",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"User4","1234",new ArrayList<>()));

            accountService.addRoleToUser("User1", "USER");
            accountService.addRoleToUser("Admin", "USER");
            accountService.addRoleToUser("Admin", "ADMIN");
            accountService.addRoleToUser("User2", "USER");
            accountService.addRoleToUser("User2", "CUSTOMER_MANAGER");
            accountService.addRoleToUser("User3", "USER");
            accountService.addRoleToUser("User3", "PRODUCT_MANAGER");
            accountService.addRoleToUser("User4", "USER");
            accountService.addRoleToUser("User4", "BILLS_MANAGER");


        };
    }

}
