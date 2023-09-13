package com.VardhanProject.Springboot_backend.services.impl;

import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.payloads.UserDto;
import com.VardhanProject.Springboot_backend.repos.UserRepo;
import com.VardhanProject.Springboot_backend.services.UserService;
import com.VardhanProject.Springboot_backend.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer uid) {
        User user = this.userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User"," id ",uid));
        user.setName(userDto.getName());
        user.setUid(userDto.getUid());
        user.setRole(userDto.getRole());
        user.setNumber(userDto.getNumber());

        User updateUser = this.userRepo.save(user);

        return this.userToDto(updateUser);
    }

    @Override
    public UserDto getUserById(Integer uid) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    public User dtoToUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setUid(userDto.getUid());
        user.setRole(userDto.getRole());
        user.setNumber(userDto.getNumber());
        return user;
    }

    public  UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUid(user.getUid());
        userDto.setName(user.getName());
        userDto.setRole(user.getRole());
        userDto.setNumber(user.getNumber());
        return userDto;
    }
}
