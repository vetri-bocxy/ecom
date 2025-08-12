package com.bocxy.ecom.createDTO;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateUserDTO {

	
	@Column(length = 50)
	private String username;
	
    @Size(min = 8, max = 20)
	private String password;
	
	@Column(length=100)
	private String division;
	
	private String role;
}
