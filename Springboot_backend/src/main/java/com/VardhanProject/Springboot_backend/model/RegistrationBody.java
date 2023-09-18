package com.VardhanProject.Springboot_backend.model;

import jakarta.validation.constraints.*;
import lombok.Getter;

public class RegistrationBody {
    @Getter
    @NotBlank
    @Size(min = 3)
    @NotNull
    private String username;

    @Getter
    @Email
    @NotBlank
    @NotNull
    private String email;

    @Getter
    @NotBlank
    @Size(min = 8)
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    //8 Characters(At least 1 Capital,1 small,1 special character, 1 number)
    private String password;

    @Getter
    @NotBlank
    @NotNull
    private String firstName;

    @Getter
    @NotBlank
    @NotNull
    private String lastName;

}
