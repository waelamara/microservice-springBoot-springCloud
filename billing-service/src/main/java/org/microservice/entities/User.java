package org.microservice.entities;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Collection<Role> roles = new ArrayList<>();
}
