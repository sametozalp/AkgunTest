package com.ozalp.AkgunTest.dtos.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateEmployeeRequest {

    private String name;

    private String surname;

    private String phoneNumber;

    private String socialSecurityNumber;

}
