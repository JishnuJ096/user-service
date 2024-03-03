package com.user.registration.service.resources;

import com.user.registration.service.entity.Address;
import jakarta.persistence.Embedded;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequest {

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Address address;

    private String email;

    private String password;
}
