package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public void userRegistration(@RequestBody UserDto user){
        User users = new User();
        users.setId(user.getId());
        users.setUsername(user.getUsername());
        users.setPassword(user.getPassword());
        users.setRole(user.getRole());

        userService.saveUser(users);
    }

}
