package com.example.Registration.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class Config {

	@Autowired
	UserDetailsService imp;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider newbornprovider() {

		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();

		auth.setUserDetailsService(imp);
		auth.setPasswordEncoder(encoder());

		return auth;

	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(newbornprovider());

	}

	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().requestMatchers("/register", "/h").permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/log") .loginProcessingUrl("/ki") .defaultSuccessUrl("/hi",true).permitAll().and().logout()
				.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/log?logout")
				.permitAll();

		return http.build();
	}
}
