package com.marketplace.auth.services;

import com.marketplace.auth.dto.JwtAuthenticationResponse;
import com.marketplace.auth.dto.LoginRequest;
import com.marketplace.auth.dto.UserRegisterRequest;
import com.marketplace.auth.exceptions.EmailAlreadyExistsException;
import com.marketplace.auth.exceptions.UserNotFoundException;
import com.marketplace.auth.models.User;
import com.marketplace.auth.models.UserRole;
import com.marketplace.auth.repository.UserRepository;
import com.marketplace.auth.security.CustomUserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Override
    public void register(UserRegisterRequest request) {
        Optional<User> userOptional = userRepository.findUserByEmail(request.email());
        if (userOptional.isPresent()) {
            throw new EmailAlreadyExistsException("User already exists");
        }

        User user = User.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(UserRole.USER)
                .build();

        userRepository.save(user);
    }

    @Override
    public JwtAuthenticationResponse signIn(LoginRequest request) {
        Optional<User> userOptional = userRepository.findUserByEmail(request.email());
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        ));

        User user = userOptional.get();

        UserDetails userDetails = new CustomUserDetailsImpl(user);
        String token = jwtService.generateToken(userDetails);

        return new JwtAuthenticationResponse(token);
    }
}
