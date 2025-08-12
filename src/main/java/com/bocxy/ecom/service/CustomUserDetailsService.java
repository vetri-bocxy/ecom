package com.bocxy.ecom.service;


import com.bocxy.ecom.model.User;
import com.bocxy.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        // Fetch user by identifier (username, email, etc.)
        Optional<User> user = userRepository.findByEmail(identifier);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with identifier: " + identifier);
        }

        // Extract roles or authorities
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.get().getRole().name())); // Assuming Role is an Enum

        // Return a Spring Security User object
        return new org.springframework.security.core.userdetails.User(
                user.get().getEmail(),
                user.get().getPassword(),  // Password must be hashed
                authorities
        );
    }

}
