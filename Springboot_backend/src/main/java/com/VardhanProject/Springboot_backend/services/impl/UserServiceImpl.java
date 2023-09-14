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
    private ModelMapper modelMapper;
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
        user.setRole(userDto.getRole());
        user.setNumber(userDto.getNumber());
        user.setPassword(userDto.getPassword());

        User updateUser = this.userRepo.save(user);

        return this.userToDto(updateUser);
    }

    @Override
    public UserDto getUserById(Integer uid) {
        User user = this.userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User","Id",uid));
        System.out.println(user.getPassword());
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = this.userRepo.findAll();
       List<UserDto> userDtoList=  userList.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtoList;
    }

    public User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto,User.class);
//        user.setName(userDto.getName());
//        user.setUid(userDto.getUid());
//        user.setRole(userDto.getRole());
//        user.setNumber(userDto.getNumber());
//        user.setPassword(userDto.getPassword());

        return user;
    }

    public  UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user,UserDto.class);

//        userDto.setUid(user.getUid());
//        userDto.setName(user.getName());
//        userDto.setRole(user.getRole());
//        userDto.setNumber(user.getNumber());
//        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
