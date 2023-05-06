package com.example.Registration.entities;

import java.util.Collection;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User Table")
public class user {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "User_Id")
	private String id;

	@Column(name = "First Name")
	private String firstname;

	@Column(name = "Last Name")
	private String lastname;

	@Column(name = "email")
	private String email;

	public user(String firstname, String lastname, String email, String password, Collection<Roles> role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public user() {
		super();
	}

	@Column(name = "Password Encrypted ")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinTable(

			name = "userandroles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "User_Id"), inverseJoinColumns = @JoinColumn(name = "Role_id", referencedColumnName = "Role_id"))
	private Collection<Roles> role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Roles> getRole() {
		return role;
	}

	public void setRole(Collection<Roles> role) {
		this.role = role;
	}

}
