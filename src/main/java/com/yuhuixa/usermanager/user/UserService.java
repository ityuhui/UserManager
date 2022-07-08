package com.yuhuixa.usermanager.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    void addUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email has existed");
        }
        userRepository.save(user);
    }

    void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("The user with id " + userId + " does not exist.");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    void updateUser(Long userId, String name, String email) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new IllegalStateException("user with id " + userId + " does not exist.");
        }
        User user = userOptional.get();
        
        if (name != null &&
            name.length() > 0 &&
            !Objects.equals(user.getName(), name)) {
                user.setName(name);
        }

        if (email != null &&
            email.length() > 0 &&
            !Objects.equals(user.getEmail(), email)) {

                Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
                if (userByEmail.isPresent()) {
                    throw new IllegalStateException("Email has existed");
                }

                user.setEmail(email);
        }

        userRepository.save(user);
    
    }

}
