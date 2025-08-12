package com.bocxy.ecom.auth;

import lombok.Data;

@Data
public class AdminLoginRequest {
    private String email;
    private String password;
}
