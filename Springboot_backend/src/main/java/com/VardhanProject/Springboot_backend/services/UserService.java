package com.VardhanProject.Springboot_backend.services;

import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer uid);
    UserDto getUserById(Integer uid);
//    List<UserDto> getAllUser();
}
