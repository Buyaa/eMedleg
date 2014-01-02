package com.mn.emedleg.security;

import java.util.Map;


public class UserTransfer {

	private final String userName;

	private final Map<String, Boolean> roles;

	private final String token;

	private final String name;
	
	public UserTransfer(String userName, Map<String, Boolean> roles, String token, String fullName) {

		this.userName = userName;
		this.roles = roles;
		this.token = token;
		this.name=fullName;
	}

	public String getFullName(){
			return name;
	}
	public String getName() {

		return this.userName;
	}


	public Map<String, Boolean> getRoles() {

		return this.roles;
	}


	public String getToken() {

		return this.token;
	}

}
