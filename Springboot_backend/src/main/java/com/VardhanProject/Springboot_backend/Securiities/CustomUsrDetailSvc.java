package com.VardhanProject.Springboot_backend.Securiities;

import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.repos.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CustomUsrDetailSvc implements UserDetailsService {

    @Autowired
    private UserRepo usrRepo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //loading user from database by username (in our system email act as username)
        log.debug("fetching user with email : {}", userName);
        Optional<User> user = usrRepo.findByUsername(userName);
        if (user.isPresent()){
            return user.get();
        } else {
            log.error("No user found in database with email : {}", userName);
            throw new UsernameNotFoundException("No user found in database with email : " + userName);
        }
    }
}