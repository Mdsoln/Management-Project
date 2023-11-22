package com.journals.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String fullname;
    private String email;
    private String password;
    //its value here a user will be asked to register as e.g. researcher, editor or else, using radio buttons
    private String registerType;

}
