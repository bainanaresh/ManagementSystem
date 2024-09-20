package com.baina.mgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String userName;
	
	private String password;
	
	private String mobile;
	
	private String role;
	

}
