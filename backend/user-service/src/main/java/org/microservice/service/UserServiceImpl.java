package org.microservice.service;

import org.microservice.dao.AppRoleRepository;
import org.microservice.dao.AppUserRepository;
import org.microservice.entities.AppRole;
import org.microservice.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private AppRoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser findUserById(Long id){
		return userRepository.findById(id).get();
	}
	
	@Override
	public AppUser saveUser(AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public AppUser findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		AppUser user =userRepository.findByEmail(email);
		AppRole role =roleRepository.findByRole(roleName);
		user.getRoles().add(role);
		//Puisque il est transactional on a pas besoin de faire "userRepository.save()"
	}

}
