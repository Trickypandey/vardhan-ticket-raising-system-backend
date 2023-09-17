package com.VardhanProject.Springboot_backend.controllers.authentication.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class LoginBody {
    @Getter
    @NotBlank
    @NotNull
    private String username;

    @Getter
    @NotBlank
    @NotNull
    private String password;
}
