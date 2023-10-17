package com.VardhanProject.Springboot_backend.services.impl;

import com.VardhanProject.Springboot_backend.entities.Address;
import com.VardhanProject.Springboot_backend.entities.Customer;
import com.VardhanProject.Springboot_backend.payloads.CustomerDto;
import com.VardhanProject.Springboot_backend.repos.CustomerRepository;
import com.VardhanProject.Springboot_backend.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDto addCustomer(CustomerDto customerDto) {
        printCustomerDto(customerDto);
        // Map the CustomerDto to a Customer entity
        Customer customer = modelMapper.map(customerDto, Customer.class);

        // Map the AddressDto objects to Address entities within the Customer entity
        List<Address> addresses = customerDto.getAddresses().stream()
                .map(addressDto -> modelMapper.map(addressDto, Address.class))
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
