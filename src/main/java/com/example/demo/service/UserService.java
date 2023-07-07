package com.example.demo.service;


import com.example.demo.dto.UserDto;
import com.example.demo.models.User;


public interface UserService {
    void saveUser(User userDto);
    User findByEmail(String email);
    User findByUsername(String username);
}
