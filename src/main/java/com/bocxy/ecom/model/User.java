package com.bocxy.ecom.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	private boolean status;

	@Column
	private String otp;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false, nullable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

}
