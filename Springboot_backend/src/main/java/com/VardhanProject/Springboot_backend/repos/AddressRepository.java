package com.VardhanProject.Springboot_backend.repos;

import com.VardhanProject.Springboot_backend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findById(Integer id);
}