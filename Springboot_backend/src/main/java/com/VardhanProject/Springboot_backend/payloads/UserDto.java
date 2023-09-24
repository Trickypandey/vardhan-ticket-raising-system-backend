package com.VardhanProject.Springboot_backend.payloads;


import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int uid ;

    @NotEmpty
    @Size(min = 4 , message = "Username must be of 4 characters")
    private String name ;

    private Integer number;

    @NotEmpty
    private String password;

    @NotEmpty
    private String role ;
}
