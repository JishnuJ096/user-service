package com.user.registration.service.entity;

import com.user.registration.service.converter.StringListConverter;
import com.user.registration.service.resources.UserData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Embedded
    private Address address;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="roles")
    @Convert(converter = StringListConverter.class)
    private List<String> roles = new ArrayList<>();

    public User(UserData request) {
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.address = request.getAddress();
        this.email = request.getEmail();
        this.dateOfBirth = request.getDateOfBirth();
        this.password = request.getPassword();
        this.roles=request.getRoles();
    }
}
