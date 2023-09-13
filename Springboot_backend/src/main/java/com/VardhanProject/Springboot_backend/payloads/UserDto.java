package com.VardhanProject.Springboot_backend.payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int uid ;
    private String password;
    private String name ;
    private String role ;
    private Integer number;
}
