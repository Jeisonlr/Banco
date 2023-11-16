package com.example.ProyectoBancoJPA.Auth;

import com.example.ProyectoBancoJPA.Jwt.JwtService;
import com.example.ProyectoBancoJPA.Request.LoginRequest;
import com.example.ProyectoBancoJPA.Request.RegisterRequest;

import com.example.ProyectoBancoJPA.user.Role;
import com.example.ProyectoBancoJPA.user.User;
import com.example.ProyectoBancoJPA.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado"));
            String token = jwtService.getToken(user);
            return AuthResponse.builder()
                    .token(token)
                    .build();
        } catch (AuthenticationException e) {
            throw new AuthenticationException("autenticación falló", e) {
            };
        }
    }

    public AuthResponse register(RegisterRequest request) {
        try {
            User user = User.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .country(request.getCountry())
                    .role(Role.USER)
                    .build();

            userRepository.save(user);

            return AuthResponse.builder()
                    .token(jwtService.getToken(user))
                    .build();
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("Username already exists", e);
        } catch (Exception e) {
            throw new RuntimeException("Registro falló", e);
        }
    }
}