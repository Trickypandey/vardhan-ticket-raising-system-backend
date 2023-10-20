package com.VardhanProject.Springboot_backend.controllers;

import com.VardhanProject.Springboot_backend.entities.Address;
import com.VardhanProject.Springboot_backend.entities.Customer;
import com.VardhanProject.Springboot_backend.payloads.AddressDto;
import com.VardhanProject.Springboot_backend.payloads.CustomerDto;
import com.VardhanProject.Springboot_backend.repos.AddressRepository;
import com.VardhanProject.Springboot_backend.repos.CustomerRepository;
import com.VardhanProject.Springboot_backend.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    ModelMapper modelMapper;

   @Autowired
   private  CustomerService customerService;

   @Autowired
   private CustomerRepository customerRepository;

   @Autowired
   private AddressRepository addressRepository;

    @PostMapping("/add")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto addedCustomer = customerService.addCustomer(customerDto);
        return new ResponseEntity<>(addedCustomer,HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public List<Customer> getAllCustomersWithAddresses() {
        return customerRepository.findAllCustomersWithAddresses();
    }

    @GetMapping("/getAddress/{addressId}")
    public ResponseEntity<AddressDto> getAddressByAddressId(@PathVariable Integer addressId) {
        Optional<Address> address = addressRepository.findById(addressId);

        AddressDto savedAddressDto = modelMapper.map(address,AddressDto.class);

        if (address == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(savedAddressDto);
        }
    }
}
