package com.baina.mgmt.service;

import com.baina.mgmt.dto.JwtAuthResponse;
import com.baina.mgmt.dto.LoginDto;
import com.baina.mgmt.dto.UserRegistrationDto;

public interface AuthService {
	
	public String registerUser(UserRegistrationDto userRegistrationDto);
	
	JwtAuthResponse login(LoginDto loginDto);

}
