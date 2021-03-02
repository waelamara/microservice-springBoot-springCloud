package org.microservice.securityservice.service;

import lombok.AllArgsConstructor;
import org.microservice.securityservice.dao.AppRoleRepository;
import org.microservice.securityservice.dao.AppUserRepository;
import org.microservice.securityservice.entities.AppRole;
import org.microservice.securityservice.entities.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw =appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser appUser=appUserRepository.findByUsername((userName));
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        appUser.getApproles().add(appRole);

    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepository.findByUsername((userName));
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
