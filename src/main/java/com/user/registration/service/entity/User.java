package com.user.registration.service.entity;

import com.user.registration.service.resources.UserRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Embedded
    private Address address;

    private String email;

    private String password;

    public User(UserRequest request) {
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.address = request.getAddress();
        this.email = request.getEmail();
        this.dateOfBirth = request.getDateOfBirth();
        this.password = request.getPassword();
    }
}
