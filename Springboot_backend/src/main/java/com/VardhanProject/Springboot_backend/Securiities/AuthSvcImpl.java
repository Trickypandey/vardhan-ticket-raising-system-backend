package com.VardhanProject.Springboot_backend.Securiities;


import com.VardhanProject.Springboot_backend.config.mapperconverter.DtoConverter;
import com.VardhanProject.Springboot_backend.entities.User;
import com.VardhanProject.Springboot_backend.model.LoginBody;
import com.VardhanProject.Springboot_backend.payloads.UserDto;
import com.VardhanProject.Springboot_backend.repos.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class AuthSvcImpl {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CustomUsrDetailSvc customUsrDetailSvc;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DtoConverter<UserDto, User> dtoConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo usrRepo;
//    @Autowired
//    private RoleRepo roleRepo;

    public JwtResponse authenticate(LoginBody loginBody) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginBody.getUsername(), loginBody.getPassword());
        this.authenticationManager.authenticate(authenticationToken);
        UserDetails userDetails = this.customUsrDetailSvc.loadUserByUsername(loginBody.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(token);
        jwtResponse.setUserDetails(userDetails);

        return jwtResponse;
    }
//    public Usr signUpUsr(\UsrDto usrDto) throws ResourceNotFound, ResourceAlreadyExists {
//        log.info("Started execution of signUpUsr method");
//
//        List<Usr> userList = usrRepo.findAll()
//                .stream()
//                .filter(usr -> usr.getEmail().equalsIgnoreCase(usrDto.getEmail()))
//                .toList();
//        Optional<Role> role = roleRepo.findById(ConstantVal.NORMAL_USER);
//        Set<Role> roles = new HashSet<>();
//        // Initializing model
//        if(role.isPresent()){
//            roles.add(role.get());
//        }
//        else {
//            throw new ResourceNotFound("Server can't assign USER role, Please contact service provider");
//        }
//        Usr usr;
//        if (userList.isEmpty()) {
//            usr = dtoConverter.convert(usrDto, Usr.class);
//            usr.setPassword(passwordEncoder.encode(usrDto.getPassword()));
//            usr.setRoles(roles);
//            usrRepo.save(usr);
//            log.info("SignUp Successfully");
//        } else {
//            throw new ResourceAlreadyExists("This user already exits! Please try with another email");
//        }
//        return usr;
//    }
}