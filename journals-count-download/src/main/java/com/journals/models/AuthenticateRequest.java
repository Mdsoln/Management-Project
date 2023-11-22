package com.journals.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticateRequest {
    private String email;
    private String password;

}
