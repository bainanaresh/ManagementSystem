package com.baina.mgmt.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baina.mgmt.entity.User;
import com.baina.mgmt.repository.RoleRepository;
import com.baina.mgmt.repository.UserRepository;

@Service
public class CustomUserDetalsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOremail) throws UsernameNotFoundException {

		User user = userRepository.findByUserNameOrEmail(usernameOremail, usernameOremail)
				.orElseThrow(() -> new IllegalArgumentException("user not found for this userName"));

		Set<SimpleGrantedAuthority> roles = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), roles);
	}

}
