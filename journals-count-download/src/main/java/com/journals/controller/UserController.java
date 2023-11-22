package com.journals.controller;

import com.journals.models.AuthenticateRequest;
import com.journals.models.AuthenticationResponse;
import com.journals.models.UserDto;
import com.journals.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @CrossOrigin()
    @PostMapping("/register")
    public ResponseEntity<String> registrations(@RequestBody UserDto userDto){
        userService.saveUsers(userDto);
        return ResponseEntity.ok("Registered successfully");
    }

    @CrossOrigin()
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticateRequest authenticateRequest
            ){
        return ResponseEntity.ok(userService.authenticate(authenticateRequest));
    }

    @CrossOrigin()
    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(
    ){
        List<UserDto> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
