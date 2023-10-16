package com.VardhanProject.Springboot_backend.services.impl;

import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.payloads.UserDto;
import com.VardhanProject.Springboot_backend.repos.UserRepo;
import com.VardhanProject.Springboot_backend.services.UserService;
import com.VardhanProject.Springboot_backend.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {


        User user = this.modelMapper.map(userDto,User.class);
        User savedUser = this.userRepo.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer uid) {
        User user = this.userRepo.findById(uid.toString()).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", uid));

        modelMapper.map(userDto, user);
        User updateUser = this.userRepo.save(user);

        return modelMapper.map(updateUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer uid) {
        User user = this.userRepo.findById(uid.toString()).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", uid));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

}
