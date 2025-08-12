package com.bocxy.ecom.DTO;

import com.bocxy.ecom.response.JwtResponse;

import lombok.Data;

@Data
public class JwtDTO {
    private JwtResponse jwtResponse;

    public JwtDTO(JwtResponse jwtResponse) {
        this.jwtResponse = jwtResponse;
    }

    // Other constructors if needed

    public JwtResponse getJwtResponse() {
        return jwtResponse;
    }

    public void setJwtResponse(JwtResponse jwtResponse) {
        this.jwtResponse = jwtResponse;
    }


}



