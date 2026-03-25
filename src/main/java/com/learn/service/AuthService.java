package com.learn.service;

import com.learn.dto.request.LoginRequestDTO;
import com.learn.dto.request.RegisterRequestDTO;
import com.learn.dto.response.AuthResponseDTO;
import com.learn.entity.User;
import com.learn.exception.ConflictException;
import com.learn.repository.UserRepository;
import com.learn.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.learn.entity.Role;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO register(RegisterRequestDTO request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ConflictException("Email already Registered: " + request.getEmail());
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponseDTO(token , user.getEmail() , user.getRole().name());
    }

    public AuthResponseDTO login(LoginRequestDTO requestDTO) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDTO.getEmail(),
                        requestDTO.getPassword()

                )
        );

        User user = userRepository.findByEmail(requestDTO.getEmail())
                .orElseThrow();
        String token = jwtService.generateToken(user.getEmail());
        return new AuthResponseDTO(token,user.getEmail(),user.getRole().name());
    }
}
