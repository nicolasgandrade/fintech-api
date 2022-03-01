package com.nicolasgandrade.fintech.service;

import com.nicolasgandrade.fintech.dto.UserRequest;
import com.nicolasgandrade.fintech.exception.ResourceNotFoundException;
import com.nicolasgandrade.fintech.model.User;
import com.nicolasgandrade.fintech.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .cpf(request.getCpf())
                .build();

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
