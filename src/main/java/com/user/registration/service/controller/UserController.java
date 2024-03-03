package com.user.registration.service.controller;

import com.user.registration.service.entity.User;
import com.user.registration.service.resources.UserRequest;
import com.user.registration.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
}
