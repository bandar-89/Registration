package com.example.Registration.Repo;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Registration.Services.userservice;
import com.example.Registration.entities.Roles;
import com.example.Registration.entities.user;
import com.example.Registration.entities.userforregistration;

@Service
@ComponentScan
public class Serviceimp implements userservice {

	@Autowired
	repository repo;

	@Autowired
	@Lazy
	public BCryptPasswordEncoder b;

	@Override
	public void saveuser(userforregistration u) {

		user real = new user(u.getFirstname(), u.getLastname(), u.getEmail(), b.encode(u.getPassword()),
				Arrays.asList(new Roles("Role Of User")));

		repo.save(real);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user u = repo.findByEmail(username);

		if (u == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(),
				mapRolesToAuthorities(u.getRole()));

	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> ro) {

		return ro.stream().map(R -> new SimpleGrantedAuthority(R.getName())).collect(Collectors.toList());
	}

}
