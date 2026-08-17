package com.manpower.platform.service;

import com.manpower.platform.dto.LoginRequest;
import com.manpower.platform.dto.LoginResponse;
import com.manpower.platform.dto.RegisterRequest;
import com.manpower.platform.entity.User;
import com.manpower.platform.exception.EmailAlreadyExistsException;
import com.manpower.platform.exception.InvalidCredentialsException;
import com.manpower.platform.exception.PhoneAlreadyExistsException;
import com.manpower.platform.repository.UserRepository;
import com.manpower.platform.security.JwtService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // =========================
    // REGISTER USER
    // =========================

    public User registerUser(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new EmailAlreadyExistsException(
                    "Email already registered"
            );
        }

        if (userRepository.existsByPhone(request.getPhone())) {

            throw new PhoneAlreadyExistsException(
                    "Phone number already registered"
            );
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        // Hash password before storing it
        user.setPasswordHash(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole(request.getRole());

        // Newly registered users require verification
        user.setAccountStatus("PENDING_VERIFICATION");

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }


    // =========================
    // LOGIN USER
    // =========================

    public LoginResponse loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid email or password"
                        )
                );

        // Verify password
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPasswordHash())) {

            throw new InvalidCredentialsException(
                    "Invalid email or password"
            );
        }

        // Generate JWT after successful authentication
        String token = jwtService.generateToken(
                user.getEmail()
        );

        return new LoginResponse(
        user.getId(),
        user.getFirstName(),
        user.getEmail(),
        user.getRole(),
        "Login successful",
        token,
        "Bearer",
        3600
    );
    }
}