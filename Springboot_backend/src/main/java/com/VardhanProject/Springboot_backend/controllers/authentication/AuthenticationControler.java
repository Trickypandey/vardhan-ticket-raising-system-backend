package com.VardhanProject.Springboot_backend.controllers.authentication;


import com.VardhanProject.Springboot_backend.Securiities.AuthSvcImpl;
import com.VardhanProject.Springboot_backend.Securiities.JwtAuthRequest;
import com.VardhanProject.Springboot_backend.Securiities.JwtResponse;
import com.VardhanProject.Springboot_backend.Securiities.JwtUtil;
import com.VardhanProject.Springboot_backend.model.LoginResponse;
import com.VardhanProject.Springboot_backend.model.LoginBody;
import com.VardhanProject.Springboot_backend.exceptions.UserAlreadyExistsException;
import com.VardhanProject.Springboot_backend.model.RegistrationBody;
import com.VardhanProject.Springboot_backend.payloads.Response;
import com.VardhanProject.Springboot_backend.services.UserService;
import com.VardhanProject.Springboot_backend.services.authentication.UserServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/auth")
public class AuthenticationControler {

    @Autowired
    private AuthSvcImpl authSvc;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserServices userServices;
    public void AuthenticationController(UserServices userService){
        this.userServices=userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userServices.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            // You might want to handle the exception more gracefully here
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }
    }
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestBody LoginBody loginBody) {
        UserDetails userDetails = userServices.loginUser(loginBody);

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new JwtResponse(null,"Username or password is incorrect", null));

        }

        String jwt = jwtUtil.generateToken(userDetails);

        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {
            JwtResponse response = new JwtResponse();
            response.setToken(jwt);
            response.setMessage("Login Successfull");
            response.setUserDetails(userDetails);
            return ResponseEntity.ok(response);
        }
    }


}
