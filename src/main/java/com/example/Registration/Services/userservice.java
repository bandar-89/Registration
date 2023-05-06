package com.example.Registration.Services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Registration.entities.userforregistration;

public interface userservice extends UserDetailsService {

	public void saveuser(userforregistration u);

}
