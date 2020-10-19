package org.microservice.service;

import org.microservice.entities.AppRole;
import org.microservice.entities.AppUser;

public interface IUserService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public AppUser findUserById(Long id);
	public AppUser findUserByEmail(String email);
	public void addRoleToUser(String email,String role);

}
