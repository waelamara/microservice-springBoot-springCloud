package org.microservice.securityservice.api;

import lombok.AllArgsConstructor;
import org.microservice.securityservice.entities.AppUser;
import org.microservice.securityservice.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
        return accountService.listUsers();
    }

}
