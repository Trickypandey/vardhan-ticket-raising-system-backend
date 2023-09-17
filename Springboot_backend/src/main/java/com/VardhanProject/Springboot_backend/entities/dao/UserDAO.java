package com.VardhanProject.Springboot_backend.entities.dao;

import org.springframework.data.repository.CrudRepository;
import com.VardhanProject.Springboot_backend.entities.User;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

    Optional<User> findByEmailIgnoreCase(String email);


}
