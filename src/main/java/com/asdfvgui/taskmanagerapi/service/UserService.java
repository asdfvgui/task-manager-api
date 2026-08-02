package com.asdfvgui.taskmanagerapi.service;

import com.asdfvgui.taskmanagerapi.model.entity.User;
import com.asdfvgui.taskmanagerapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(String name, String email) {

        User user = new User(name, email);
        return userRepository.save(user);

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow();

    }

    public User updateUser(Long id, String name, String email) {

        User user = userRepository.findById(id)
                .orElseThrow();

        user.updateName(name);
        user.updateEmail(email);

        return userRepository.save(user);

    }

    public User deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow();

        userRepository.delete(user);

        return user;
    }
}
