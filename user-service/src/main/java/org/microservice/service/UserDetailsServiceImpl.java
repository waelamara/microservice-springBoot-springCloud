package org.microservice.service;

import java.util.ArrayList;
import java.util.Collection;

import org.microservice.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService iUserService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = iUserService.findUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getRole()));
        });
        return new User(user.getEmail(), user.getPassword(), authorities);
    }

}
