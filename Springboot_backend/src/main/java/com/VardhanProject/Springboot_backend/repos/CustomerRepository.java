package com.VardhanProject.Springboot_backend.repos;

import com.VardhanProject.Springboot_backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Define a custom query to fetch customers with their addresses
    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.addresses")
    List<Customer> findAllCustomersWithAddresses();
}