package com.VardhanProject.Springboot_backend.services.authentication;

import com.VardhanProject.Springboot_backend.Securiities.JwtUtil;
import com.VardhanProject.Springboot_backend.entities.dao.UserDAO;
import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.model.LoginResponse;
import com.VardhanProject.Springboot_backend.model.LoginBody;
import com.VardhanProject.Springboot_backend.model.RegistrationBody;
import com.VardhanProject.Springboot_backend.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    private UserDAO UserDAO;

    private JwtUtil jwtUtil;
    public UserServices(UserDAO UserDAO, JwtUtil jwtUtil){
        this.UserDAO=UserDAO;

        this.jwtUtil = jwtUtil;
    }

    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {

        if(UserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() &&
                UserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }

        User user=new User();
        user.setUsername(registrationBody.getUsername());
        user.setName(registrationBody.getName());
        user.setRole(registrationBody.getRole());
        user.setPassword(registrationBody.getPassword());
        user.setNumber(registrationBody.getNumber());

        return UserDAO.save(user);

    }
    public User loginUser(LoginBody loginBody) {
        Optional<User> opUser = UserDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        System.out.println(opUser + " in login user");

        if (opUser.isPresent()) {
            User user = opUser.get();

            // Compare the provided password with the stored password
            if (passwordMatches(loginBody.getPassword(), user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    private boolean passwordMatches(String providedPassword, String storedPassword) {
        // Implement your password comparison logic here
        // For example, you can use a password hashing library like BCrypt
        // Here's a simplified example assuming plain text passwords:
        return providedPassword.equals(storedPassword);
    }
}
