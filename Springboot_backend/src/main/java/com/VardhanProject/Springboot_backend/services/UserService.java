package com.VardhanProject.Springboot_backend.services;

import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer uid);
    UserDto getUserById(Integer uid);
    List<UserDto> getAllUser();
}
