package com.bocxy.ecom.config;

import com.bocxy.ecom.jwt.JwtRequestFilter;
import com.bocxy.ecom.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Dynamic CORS configuration
    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter(corsConfigurationSource());
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration baseConfig = new CorsConfiguration();
        baseConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        baseConfig.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept", "Authorization"));
        baseConfig.setAllowCredentials(true);
        baseConfig.setMaxAge(3600L);

        // Production allowed origins list (currently empty)
        List<String> allowedOrigins = List.of();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                String origin = request.getHeader("Origin");

                // Allow localhost for development
                if (origin != null && origin.startsWith("http://localhost")) {
                    CorsConfiguration localhostConfig = new CorsConfiguration(baseConfig);
                    localhostConfig.setAllowedOrigins(List.of(origin));
                    return localhostConfig;
                }

                // Allow production origins
                if (origin != null && allowedOrigins.contains(origin)) {
                    CorsConfiguration prodConfig = new CorsConfiguration(baseConfig);
                    prodConfig.setAllowedOrigins(List.of(origin));
                    return prodConfig;
                }

                return null; // block unknown origins
            }
        };

        source.registerCorsConfiguration("/**", baseConfig); // fallback
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        // Swagger endpoints
                        "/v3/api-docs/**",
                        "/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/webjars/**",
                        // Public API endpoints
                        "/api/auth/**",
                        "/api/aeAuth/login",
                        "/api/dealerRegister/**",
                        "/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
