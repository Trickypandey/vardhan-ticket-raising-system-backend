package com.VardhanProject.Springboot_backend.services;

import com.VardhanProject.Springboot_backend.payloads.CustomerDto;
import com.VardhanProject.Springboot_backend.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerDto addCustomer(CustomerDto customerDto);
    List<CustomerDto> getAllCustomer();


}
