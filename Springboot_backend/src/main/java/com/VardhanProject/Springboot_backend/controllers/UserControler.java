package com.VardhanProject.Springboot_backend.controllers;

import com.VardhanProject.Springboot_backend.payloads.UserDto;
import com.VardhanProject.Springboot_backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControler {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
        // Call the UserService to retrieve the user by ID
        UserDto resultDto = this.userService.getUserById(userId);
        return new ResponseEntity<>(resultDto,HttpStatus.CREATED);
    }
    @GetMapping("/alluser")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> allUserDto = this.userService.getAllUser();
        return ResponseEntity.ok(allUserDto);
    }



    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUserDetail(@Valid @RequestBody UserDto userDto,@PathVariable int userId) {
        // Call the UserService to retrieve the user by ID
        UserDto resultDto = this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(resultDto);
    }

}
