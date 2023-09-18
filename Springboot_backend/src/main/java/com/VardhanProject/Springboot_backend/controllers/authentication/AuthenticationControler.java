package com.VardhanProject.Springboot_backend.controllers.authentication;


import com.VardhanProject.Springboot_backend.controllers.authentication.model.LoginBody;
import com.VardhanProject.Springboot_backend.controllers.authentication.model.LoginResponse;
import com.VardhanProject.Springboot_backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth ")
public class AuthenticationControler {

    private UserService userService;
    public void AuthenticationController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException e) {
            // You might want to handle the exception more gracefully here
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }
    @PostMapping("/login")
    public ResponseEntity loginUser( @RequestBody LoginBody loginBody){
        String jwt = userService.loginUser(loginBody);
        if(jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            LoginResponse response=new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }

}
