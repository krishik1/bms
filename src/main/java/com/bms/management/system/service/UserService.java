package com.bms.management.system.service;

import com.bms.management.system.model.User;
import com.bms.management.system.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserServiceI {
    private final UserRepository userRepository;

    @Override
    public User createUser(String userName, String password) {
        return userRepository.save(new User(userName, password));
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    // Additional methods can be added here as needed
}
