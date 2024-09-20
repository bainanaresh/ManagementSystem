package com.baina.mgmt.service;

import com.baina.mgmt.dto.UserRegistrationDto;

public interface AuthService {
	
	public String registerUser(UserRegistrationDto userRegistrationDto);

}
