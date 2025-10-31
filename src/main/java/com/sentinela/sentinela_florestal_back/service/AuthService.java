package com.sentinela.sentinela_florestal_back.service;

import com.sentinela.sentinela_florestal_back.dto.AuthResponse;
import com.sentinela.sentinela_florestal_back.dto.LoginRequest;
import com.sentinela.sentinela_florestal_back.dto.RegisterRequest;
import com.sentinela.sentinela_florestal_back.dto.RegisterResponse;
import com.sentinela.sentinela_florestal_back.entity.User;
import com.sentinela.sentinela_florestal_back.repository.CityHallRepository;
import com.sentinela.sentinela_florestal_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityHallRepository cityHallRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    public RegisterResponse register(RegisterRequest request) {
        // Verifica se o email já existe
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        User user = new User();
        user.setName(request.getName());
        user.setBirthday(request.getBirthday());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStreet(request.getStreet());
        user.setNeighborhood(request.getNeighborhood());
        user.setCity(request.getCity());
        user.setState(request.getState());
        user.setZipcode(request.getZipcode());
        user.setAddressNumber(request.getAddressNumber());
        user.setComplement(request.getComplement());

        if (request.getCityHallId() != null) {
            cityHallRepository.findById(request.getCityHallId())
                    .ifPresent(user::setCityHall);
        }

        user = userRepository.save(user);

        return new RegisterResponse("Usuário cadastrado com sucesso", user.getId());
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(token, "Bearer");
    }
}
