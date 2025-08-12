package com.bocxy.ecom.auth;


import com.bocxy.ecom.jwt.JwtResponse;
import com.bocxy.ecom.jwt.JwtTokenUtil;
import com.bocxy.ecom.model.User;
import com.bocxy.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AeAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public JwtResponse login(AdminLoginRequest loginRequest) {
        // Find user by email
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        // Check if user is active
        if (!user.isStatus()) {
            throw new IllegalArgumentException("Your account is deactivated. Please contact support.");
        }

        // Validate password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        // Generate JWT tokens
        String accessToken = jwtTokenUtil.generateAccessToken(user.getEmail());
        String refreshToken = jwtTokenUtil.generateRefreshToken(user.getEmail());

        return new JwtResponse(accessToken, refreshToken, user.getEmail(), user.getRole().name(), user.getId());
    }

}
