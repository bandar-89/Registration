package com.example.Registration.entities;

public class userforregistration {

	public String Firstname;

	public String Lastname;

	public String password;

	public String Email;

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public userforregistration() {
	}

	public userforregistration(String firstname, String lastname, String password, String email) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		this.password = password;
		Email = email;
	}

}
