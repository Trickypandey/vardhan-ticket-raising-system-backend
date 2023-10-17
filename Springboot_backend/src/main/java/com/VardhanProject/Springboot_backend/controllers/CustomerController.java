package com.VardhanProject.Springboot_backend.controllers;

import com.VardhanProject.Springboot_backend.entities.Customer;
import com.VardhanProject.Springboot_backend.payloads.CustomerDto;
import com.VardhanProject.Springboot_backend.repos.CustomerRepository;
import com.VardhanProject.Springboot_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        printCustomerDto(customerDto);
        CustomerDto addedCustomer = customerService.addCustomer(customerDto);
        return new ResponseEntity<>(addedCustomer,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomersWithAddresses() {
        return customerRepository.findAllCustomersWithAddresses();
    }

    public static void printCustomerDto(CustomerDto customerDto) {
        System.out.println("Customer ID: " + customerDto.getCustomer_id());
        System.out.println("Customer Name: " + customerDto.getCustomer_name());
        System.out.println("Customer Contact Person: " + customerDto.getCustomer_contact_person());
        System.out.println("Customer Email: " + customerDto.getCustomer_email());
        System.out.println("Customer Phone: " + customerDto.getCustomer_phone());

        System.out.println("Addresses:");
        for (int i = 0; i < customerDto.getAddresses().size(); i++) {
            System.out.println("Address " + (i + 1) + ":");
            System.out.println("  Address Line 1: " + customerDto.getAddresses().get(i).getAddress_line_1());
            System.out.println("  Area: " + customerDto.getAddresses().get(i).getArea());
            System.out.println("  District: " + customerDto.getAddresses().get(i).getDistrict());
            System.out.println("  State: " + customerDto.getAddresses().get(i).getState());
            System.out.println("  Latitude: " + customerDto.getAddresses().get(i).getLat());
            System.out.println("  Longitude: " + customerDto.getAddresses().get(i).getLongitude());
        }
    }
}
