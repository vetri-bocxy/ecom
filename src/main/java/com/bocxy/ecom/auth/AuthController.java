package com.bocxy.ecom.auth;


import com.bocxy.ecom.DTO.ResponseDTO;
import com.bocxy.ecom.jwt.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/passwordReset")
    public ResponseEntity<ResponseDTO> resetPwd(@RequestBody PasswordResetReqDTO passwordResetReqDTO, @RequestParam String email){
        ResponseDTO responseDTO=aeAuthService.resetPwd(passwordResetReqDTO,email);
        return ResponseEntity.ok(responseDTO);
    }
}
