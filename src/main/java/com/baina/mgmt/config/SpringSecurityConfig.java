package com.baina.mgmt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.baina.mgmt.security.JwtAuthenticationEntryPoint;
import com.baina.mgmt.security.JwtAuthenticationFilter;

@Configuration
public class SpringSecurityConfig {
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
    private JwtAuthenticationFilter authenticationFilter;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((authorize)->{
			authorize.requestMatchers(HttpMethod.POST,"/api/**").hasRole("ADMIN");
			authorize.requestMatchers(HttpMethod.PUT,"/api/**").hasRole("ADMIN");
			authorize.requestMatchers(HttpMethod.DELETE,"/api/**").hasRole("ADMIN");
			//authorize.requestMatchers(HttpMethod.GET,"/api/**").hasAnyRole("ADMIN","USER");
			 authorize.requestMatchers(HttpMethod.POST,"/auth/**").permitAll();
			 authorize.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll();
			authorize.anyRequest().permitAll();
			
		}
		).httpBasic(Customizer.withDefaults());
		
		http.exceptionHandling( exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint));

        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception {
		
		return configuration.getAuthenticationManager();
	}

	/*
	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails naresh = User.builder().username("naresh").password(passwordEncoder().encode("naresh"))
				.roles("USER").build();

		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(naresh, admin);
	} */
}
