package com.bocxy.ecom.auth;


import com.bocxy.ecom.DTO.ResponseDTO;
import com.bocxy.ecom.jwt.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aeAuth")
public class AuthController {

    @Autowired
    private AeAuthService aeAuthService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody AdminLoginRequest adminLoginRequest) {
        JwtResponse jwtResponse = aeAuthService.login(adminLoginRequest);
        ResponseDTO responseDTO = new ResponseDTO(200,"Success",jwtResponse);
        return ResponseEntity.ok(responseDTO);
    }
}
