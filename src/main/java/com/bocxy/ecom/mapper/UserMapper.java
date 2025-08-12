package com.bocxy.ecom.mapper;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bocxy.ecom.DTO.UserDTO;
import com.bocxy.ecom.createDTO.CreateUserDTO;
import com.bocxy.ecom.model.User;



@Component
public class UserMapper {
	
	@Lazy
	private final PasswordEncoder encoder;
	

	public UserMapper(PasswordEncoder encoder) {
		super();
		this.encoder = encoder;
	}

}
