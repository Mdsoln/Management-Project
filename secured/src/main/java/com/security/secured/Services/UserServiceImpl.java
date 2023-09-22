package com.security.secured.Services;

import com.security.secured.Entity.Form;
import com.security.secured.Entity.User;
import com.security.secured.Repositories.FormRepo;
import com.security.secured.Repositories.UserRepo;
import com.security.secured.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface{
    @Autowired
    private final UserRepo repository;
    @Autowired
    private final FormRepo formRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo repository, FormRepo formRepo, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.formRepo = formRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFullName(userDto.getFirstName()+" "+userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        repository.save(user);
    }

    @Override
    public void saveOpinions(Form form) {
        formRepo.save(form);
    }
}
