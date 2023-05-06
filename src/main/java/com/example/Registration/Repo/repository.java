package com.example.Registration.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Registration.entities.user;

public interface repository extends JpaRepository<user, String> {

	user findByEmail(String Email);

}
