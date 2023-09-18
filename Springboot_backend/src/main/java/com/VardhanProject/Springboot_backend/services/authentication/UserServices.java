package com.VardhanProject.Springboot_backend.services.authentication;

import com.VardhanProject.Springboot_backend.entities.dao.UserDAO;
import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.model.LoginResponse;
import com.VardhanProject.Springboot_backend.model.LoginBody;
import com.VardhanProject.Springboot_backend.model.RegistrationBody;
import com.VardhanProject.Springboot_backend.exceptions.UserAlreadyExistsException;

import java.util.Optional;

public class UserServices {
    private UserDAO UserDAO;

    private JWTService jwtService;
    public UserService(UserDAO UserDAO, JWTService jwtService){
        this.UserDAO=UserDAO;

        this.jwtService = jwtService;
    }

    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if(UserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() &&
                UserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }

        User user=new User();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(Service.Password(registrationBody.getPassword()));
        user.setUsername(registrationBody.getUsername());

        return UserDAO.save(user);

    }
    public String loginUser(LoginBody loginBody){
        Optional<User> opUser=UserDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        if(opUser.isPresent()){
            User user=opUser.get();
        }
        return null;
    }
}
