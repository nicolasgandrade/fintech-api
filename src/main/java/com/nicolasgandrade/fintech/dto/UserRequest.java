package com.nicolasgandrade.fintech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String name;
    @Email
    private String email;
    private String password;
    private String cpf;

}
