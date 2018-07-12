package com.gildedrose.model;

public class User {

	private String userName;
	private Long id;
	private String password;
	private String firstName;
	private String lastName;
	private String email;

	public User(String userName, long id, String password, String firstName, String lastName, String email) {
		this.userName = userName;
		this.id=id;
		this.password = password;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.email = email;

	}

	

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {

		this.userName = userName;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}