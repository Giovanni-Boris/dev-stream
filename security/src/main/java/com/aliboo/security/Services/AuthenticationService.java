package com.aliboo.security.Services;

import com.aliboo.security.Controller.auth.AuthenticationRequest;
import com.aliboo.security.Controller.auth.AuthenticationResponse;
import com.aliboo.security.Controller.auth.RegisterRequest;
import com.aliboo.security.Entities.Usuario;
import com.aliboo.security.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  public AuthenticationResponse register(RegisterRequest request) {
    var user = Usuario.builder()
      .nombre(request.getUsername())
      .apellidos(request.getLastname())
      .contraseña(passwordEncoder.encode(request.getPassword()))
      .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getUsername(),
        request.getPassword()
      )
    );
    var user = userRepository.findByNombre(request.getUsername())
      .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
      .token(jwtToken)
      .build();
  }
}
