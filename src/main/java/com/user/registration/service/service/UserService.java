package com.user.registration.service.service;

import com.user.registration.service.entity.User;
import com.user.registration.service.repository.UserRepository;
import com.user.registration.service.resources.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequest userRequest) {
        User user = userRepository.save(new User(userRequest));
        return user;
    }
}
