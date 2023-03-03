package com.exam.model;
//this class is being used for giving the jwt token to the user in response
public class JwtResponse {
	String token;
	public JwtResponse(String token) {
		this.token=token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token=token;
	}
}
