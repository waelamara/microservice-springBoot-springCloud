package org.microservice.controller;

import org.microservice.entities.AppUser;
import org.microservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	 @Autowired
	 private IUserService iUserService;
	 
	 @PostMapping("/user")
	 public AppUser signUp(@RequestBody AppUser user){
		 String email=user.getEmail();
		 AppUser u = iUserService.findUserByEmail(email);
		 if(u!=null) throw new RuntimeException();
		 iUserService.saveUser(user);
		 iUserService.addRoleToUser(email, "USER");
		return user;
	 }
	 
	 @GetMapping("/user/{id}")
	 public AppUser findUserById(@PathVariable(name="id") Long id){
		return iUserService.findUserById(id);
	 }
	 
	 
}
