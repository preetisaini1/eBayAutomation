package com.ebay.common.modal;

public class User {
	private String email;
	private String password;
	private String userID;
	private String searchtext;
		
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
		public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("[Username]: %s [Password]: %s ",email,password );
	}
	
}
