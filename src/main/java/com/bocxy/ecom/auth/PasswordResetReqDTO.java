package com.bocxy.ecom.auth;

import lombok.Data;

@Data
public class PasswordResetReqDTO {
    private String newPassword;
    private String confirmPassword;
}
