package com.example.springbootapp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootapp.model.User;
import com.example.springbootapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String generatePassword(String firstName, String middleName, String lastName) {
        // Generate password by taking 2 chars from each name and 3 random digits
        String password = firstName.substring(0, 2) + middleName.substring(0, 2) + lastName.substring(0, 2);
        Random rand = new Random();
        password += String.format("%03d", rand.nextInt(1000));  // 3 random digits
        return password;
    }

    public User saveUser(String firstName, String middleName, String lastName) {
        String password = generatePassword(firstName, middleName, lastName);
        User user = new User(firstName + middleName + lastName, firstName, middleName, lastName, password);
        return userRepository.save(user);
    }
}
