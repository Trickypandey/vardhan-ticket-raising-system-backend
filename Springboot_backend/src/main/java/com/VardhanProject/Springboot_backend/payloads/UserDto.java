package com.VardhanProject.Springboot_backend.payloads;



import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private Integer uid;

//    @NotBlank(message = "Username is required")
//    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters")
    private String username;

//    @NotBlank(message = "Name is required")
    private String name;

//    @NotBlank(message = "Password is required")
//    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

//    @NotBlank(message = "Role is required")
    private String role;

//    @Pattern(regexp = "\\d{10}", message = "Number must be a 10-digit numeric value")
    private String number;

    private String user_image;

//    @NotBlank(message = "Email is required")
//    @Email(message = "Invalid email format")
    private String email;

    private List<TicketDto> ticketsAssigned;

    // Getters and setters
    // You can generate getters and setters using your IDE or Lombok if you prefer
}