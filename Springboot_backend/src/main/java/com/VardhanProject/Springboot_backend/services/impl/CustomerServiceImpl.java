package com.VardhanProject.Springboot_backend.services.impl;

import com.VardhanProject.Springboot_backend.entities.Address;
import com.VardhanProject.Springboot_backend.entities.Customer;
import com.VardhanProject.Springboot_backend.exceptions.ResourceNotFoundException;
import com.VardhanProject.Springboot_backend.payloads.AddressDto;
import com.VardhanProject.Springboot_backend.payloads.CustomerDto;
import com.VardhanProject.Springboot_backend.repos.CustomerRepository;
import com.VardhanProject.Springboot_backend.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    public CustomerDto addCustomer(CustomerDto customerDto) {
            // Map the CustomerDto to a Customer entity
            Customer customer = modelMapper.map(customerDto, Customer.class);

            // Map the AddressDto objects to Address entities within the Customer entity
            List<Address> addresses = customerDto.getAddresses().stream()
                    .map(addressDto -> {
                        Address address = modelMapper.map(addressDto, Address.class);
                        address.setCustomer(customer); // Set the Customer reference for each Address
                        return address;
                    })
                    .collect(Collectors.toList());

            customer.setAddresses(addresses);

            // Save the Customer entity
            Customer savedCustomer = this.customerRepository.save(customer);

            // Map the saved Customer entity back to a CustomerDto
            CustomerDto savedCustomerDto = modelMapper.map(savedCustomer, CustomerDto.class);
            return savedCustomerDto;
    }



    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customersList = this.customerRepository.findAllCustomersWithAddresses();

        return customersList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }


}
