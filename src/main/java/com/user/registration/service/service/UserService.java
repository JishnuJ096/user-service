package com.user.registration.service.service;

import com.user.registration.service.entity.User;
import com.user.registration.service.exception.BusinessException;
import com.user.registration.service.repository.UserRepository;
import com.user.registration.service.resources.UserData;
import com.user.registration.service.resources.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserData userRequest) {
        User user = userRepository.save(new User(userRequest));
        return new UserResponse(user);
    }

    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(()->new BusinessException("User Does not exists"));
    }

    public void deleteByid(Long id) {
        User user = findUserById(id);
        if(!Objects.isNull(user)){
            userRepository.deleteById(id);
        }
    }
}
