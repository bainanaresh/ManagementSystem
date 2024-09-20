package com.baina.mgmt.repository;



import com.baina.mgmt.entity.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	public Optional<User> findByUserName(String userName);
	
	public boolean existsByEmail(String email);
	
	public Optional<User> findByUserNameOrEmail(String userName,String email);

	
	
	

}
