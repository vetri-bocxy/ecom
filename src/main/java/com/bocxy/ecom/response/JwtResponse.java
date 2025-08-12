package com.bocxy.ecom.response;

import lombok.Data;

@Data
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String role;
	private String division;
    private String message;
	
	

	


	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public JwtResponse(String jwt, Long id, String username ,String role,String division, String message ) {
		super();
		this.token = jwt;
		this.type = type;
		this.id = id;
		this.username = username;
		this.role=role;
		this.division=division;
		this.message=message;
	}

	


}
