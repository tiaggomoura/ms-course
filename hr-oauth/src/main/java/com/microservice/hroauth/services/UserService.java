package com.microservice.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.hroauth.entities.User;
import com.microservice.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient feignClient;

	public User findByEmail(String email) {
		User user = this.feignClient.findByEmail(email).getBody();
		System.out.println("CHAMOU");
		if (user == null) {
			throw new IllegalArgumentException("Email not Found");
		}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.feignClient.findByEmail(username).getBody();
		if (user == null) {
			throw new UsernameNotFoundException("Email not Found");
		}
		return user;
	}

}
