package com.security.secured.Services;

import com.security.secured.Entity.Form;
import com.security.secured.Entity.User;
import com.security.secured.dto.UserDto;

public interface UserServiceInterface {

    User findByUserEmail(String email);

    void saveUser(UserDto userDto);

    void saveOpinions(Form form);
}
