package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @Transactional
    public User registerUser(String phoneNumber, String fullName, Role role, String city) {
        if (userRepository.findByPhoneNumber(phoneNumber).isPresent()) {
            throw new RuntimeException("Cet utilisateur existe déjà");
        }

        User user = User.builder()
                .phoneNumber(phoneNumber)
                .fullName(fullName)
                .role(role)
                .city(city)
                .trustScore(5.0)
                .build();

        return userRepository.save(user);
    }
}
