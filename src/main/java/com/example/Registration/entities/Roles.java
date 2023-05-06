package com.example.Registration.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles table")
public class Roles {

	@Id
	@Column(name = "Role_id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String Id;

	@Column(name = "role name ")
	private String name;

	public Roles() {
	}

	public Roles(String id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Roles(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
