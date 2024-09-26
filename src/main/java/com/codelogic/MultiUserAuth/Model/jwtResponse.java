package com.codelogic.MultiUserAuth.Model;

public class jwtResponse {
private String token;

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public jwtResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public jwtResponse(String token) {
	super();
	this.token = token;
}
}
