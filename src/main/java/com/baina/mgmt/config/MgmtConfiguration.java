package com.baina.mgmt.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MgmtConfiguration {
	
	@Bean
	public ModelMapper mapper() {
		return new  ModelMapper();
	}

}
