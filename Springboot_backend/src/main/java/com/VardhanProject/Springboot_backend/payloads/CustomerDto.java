package com.VardhanProject.Springboot_backend.payloads;

import com.VardhanProject.Springboot_backend.entities.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Integer customer_id;
    private String customer_name;
    private String customer_contact_person;
    private String customer_email;
    private String customer_phone;
    private List<AddressDto> addresses;
}