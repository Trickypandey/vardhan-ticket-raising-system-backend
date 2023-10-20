package com.VardhanProject.Springboot_backend.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    private Integer id;
    private String address_line_1;
    private String area;
    private String district;
    private String state;
    private String lat;
    private String longitude;
}
