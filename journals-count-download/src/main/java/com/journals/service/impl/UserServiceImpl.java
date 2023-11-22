package com.journals.service.impl;

import com.journals.configuration.JwtService;
import com.journals.entity.Users;
import com.journals.exception.NullValueFoundException;
import com.journals.exception.UserFoundException;
import com.journals.exception.WeekPasswordException;
import com.journals.models.AuthenticateRequest;
import com.journals.models.AuthenticationResponse;
import com.journals.models.UserDto;
import com.journals.repository.UserRepository;
import com.journals.roles.ApplicationRoles;
import com.journals.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUsers(UserDto userDto) {
        if (userDto.getFullname() == null || userDto.getEmail() == null
                || userDto.getPassword()== null || userDto.getFullname().isEmpty() ||
                userDto.getEmail().isEmpty()
                || userDto.getPassword().isEmpty()){
            throw new NullValueFoundException("All fields are required");
        }
        Users user = getUsers(userDto);

        Optional<Users> email = userRepository.findByEmail(userDto.getEmail());
        if (email.isPresent()){
            throw new UserFoundException("Already exist user with email: "+userDto.getEmail());
        }
        else {
            userRepository.save(user);
        }
    }

    private Users getUsers(UserDto userDto) {
        Users user = new Users();
        user.setFullname(userDto.getFullname());
        user.setEmail(userDto.getEmail());
        if (!isPasswordValid(userDto.getPassword())){
            throw new WeekPasswordException("Required password of at least 8 characters");
        }
        else {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        if ("researcher".equalsIgnoreCase(userDto.getRegisterType())){
            user.setRoles(ApplicationRoles.RESEARCHER);
        }
        else if ("editor".equalsIgnoreCase(userDto.getRegisterType())) {
            user.setRoles(ApplicationRoles.EDITOR);
        }
        else {
            user.setRoles(ApplicationRoles.USER);
        }
        return user;
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.length() >= 8;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest authenticateRequest) {
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         authenticateRequest.getEmail(),
                         authenticateRequest.getPassword()
                 )
         );
         var user = userRepository.findByEmail(authenticateRequest.getEmail())
                 .orElseThrow();
         var token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    //fetching all users available in database
    @Override
    public List<UserDto> findAllUsers() {
        List<Users> allUsers = userRepository.findAll();
        return allUsers
                .stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
    private UserDto mapToUserDto(Users users) {
       UserDto userDto = new UserDto();
       userDto.setFullname(users.getFullname());
       userDto.setEmail(users.getEmail());
       userDto.setRegisterType(users.getRoles().toString());
       return userDto;
    }
}

