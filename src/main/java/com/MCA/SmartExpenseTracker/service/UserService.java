package com.MCA.SmartExpenseTracker.service;

import com.MCA.SmartExpenseTracker.dto.LoginRequest;
import com.MCA.SmartExpenseTracker.dto.LoginResponse;
import com.MCA.SmartExpenseTracker.entity.User;
import com.MCA.SmartExpenseTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.MCA.SmartExpenseTracker.dto.LoginResponse;

import java.util.List;
import com.MCA.SmartExpenseTracker.dto.UserResponseDTO;
@Service
@RequiredArgsConstructor

public class UserService {

    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public  UserResponseDTO createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return UserResponseDTO.builder().id(savedUser.getId()).name(savedUser.getName()).email(savedUser.getEmail()).build();
    }
    public List<UserResponseDTO> getAllUsers(){
        return  userRepository.findAll().stream().map(
                user->UserResponseDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                        .toList();

    }
    private final JWTService jwtService;
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}
