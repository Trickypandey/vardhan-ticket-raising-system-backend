package com.VardhanProject.Springboot_backend.services.impl;

import com.VardhanProject.Springboot_backend.payloads.UserDto;
import com.VardhanProject.Springboot_backend.repos.UserRepo;
import com.VardhanProject.Springboot_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, Integer uid) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer uid) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }
}
