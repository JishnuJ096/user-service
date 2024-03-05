package com.user.registration.service.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {

    private String houseNumber;

    private String locality;

    private String district;

    private String state;

    private String country;

    private Long pin;

}
