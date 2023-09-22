package com.security.secured.Services;

import com.security.secured.Entity.User;
import com.security.secured.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailsService implements UserDetailsService {
    private final UserRepo repository;
    @Autowired
    public CustomDetailsService(UserRepo repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User availableUser = repository.findByUsername(username);
        if (availableUser != null) {
            return org.springframework.security.core.userdetails.User.withUsername(availableUser.getUsername())
                    .password(availableUser.getPassword())
                    .roles()
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
