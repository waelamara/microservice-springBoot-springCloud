package org.microservice.securityservice.service;

import org.microservice.securityservice.entities.AppRole;
import org.microservice.securityservice.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String userName,String roleName);
    AppUser loadUserByUserName(String userName);
    List<AppUser> listUsers();
}
