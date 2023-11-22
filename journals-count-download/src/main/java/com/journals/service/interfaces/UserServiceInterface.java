package com.journals.service.interfaces;

import com.journals.models.AuthenticateRequest;
import com.journals.models.AuthenticationResponse;
import com.journals.models.UserDto;

import java.util.List;

public interface UserServiceInterface {
    void saveUsers(UserDto userDto);

    AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest);

    List<UserDto> findAllUsers();

}
