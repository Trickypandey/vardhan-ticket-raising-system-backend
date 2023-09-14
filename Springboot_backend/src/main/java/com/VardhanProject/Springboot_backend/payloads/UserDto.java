package com.VardhanProject.Springboot_backend.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int uid ;

    @NotEmpty
    @Size(min = 3, message = "UserName must be min of 4 characters")
    private String name ;

    @NotEmpty
    private Integer number;

    @NotEmpty
    private String password;

    @NotEmpty
    private String role ;
}
