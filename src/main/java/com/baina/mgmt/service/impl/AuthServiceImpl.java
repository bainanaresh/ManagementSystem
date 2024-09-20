package com.baina.mgmt.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.baina.mgmt.dto.UserRegistrationDto;
import com.baina.mgmt.entity.Role;
import com.baina.mgmt.entity.User;
import com.baina.mgmt.repository.RoleRepository;
import com.baina.mgmt.repository.UserRepository;
import com.baina.mgmt.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String registerUser(UserRegistrationDto userRegistrationDto) {
		
		final User user= mapper.map(userRegistrationDto, User.class);
		user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
		
		final Set<Role> rolesSet = new HashSet<>();
		if (userRegistrationDto.getRole() != null && 
				userRegistrationDto.getRole().equals("admin")) {
			
			rolesSet.add(roleRepository.findByName("ROLE_ADMIN").get());
		} else {
			
			rolesSet.add(roleRepository.findByName("ROLE_USER").get());
		}
		user.setRoles(rolesSet);
		
		userRepository.save(user);
		
		return "user registered successfully";
	}

}
