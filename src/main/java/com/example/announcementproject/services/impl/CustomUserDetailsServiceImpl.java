package com.example.announcementproject.services.impl;

import com.example.announcementproject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        List<com.example.announcementproject.models.User> getAll = userRepository.findAll();

        for (com.example.announcementproject.models.User user : getAll) {
            if (userName.equals(user.getName())) {
                return new User(user.getName(), user.getPassword(), new ArrayList<>());
            }
        }
        return null;
    }
}
