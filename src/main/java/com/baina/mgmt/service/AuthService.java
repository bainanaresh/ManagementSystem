package com.baina.mgmt.service;

import com.baina.mgmt.dto.LoginDto;
import com.baina.mgmt.dto.UserRegistrationDto;

public interface AuthService {
	
	public String registerUser(UserRegistrationDto userRegistrationDto);
	
	String login(LoginDto loginDto);

}
