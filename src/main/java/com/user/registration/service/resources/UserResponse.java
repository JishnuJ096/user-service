package com.user.registration.service.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.user.registration.service.entity.Address;
import com.user.registration.service.entity.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponse {

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Address address;

    private String email;

    private String password;

    private List<String> roles;

    public UserResponse(User user) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        this.id = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dateOfBirth = user.getDateOfBirth();
        /*try {
            this.address = mapper.readValue(user.getAddress(),Address.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.password= user.getPassword();
        this.roles = user.getRoles();
    }
}
