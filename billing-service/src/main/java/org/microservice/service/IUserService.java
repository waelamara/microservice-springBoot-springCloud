package org.microservice.service;

import org.microservice.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="USER-SERVICE")
public interface IUserService {
	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable(name = "id") Long id);
}
