package com.user.registration.service.controller;

import com.user.registration.service.resources.UserData;
import com.user.registration.service.resources.UserResponse;
import com.user.registration.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Validated UserData userRequest){
        Objects.requireNonNull(userRequest,"User Request is null");
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable (value ="id") long id ){
        Objects.requireNonNull(id,"Id can not be null");
        return ResponseEntity.ok(new UserResponse(userService.findUserById(id)));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id){
        Objects.requireNonNull(id,"Id can not be null");
        userService.deleteByid(id);
    }

}
