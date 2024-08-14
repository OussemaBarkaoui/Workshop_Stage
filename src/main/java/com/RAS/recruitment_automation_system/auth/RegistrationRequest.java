package com.RAS.recruitment_automation_system.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Builder
public class RegistrationRequest {
    @NotEmpty(message ="Username is mandatory")
    @NotEmpty(message ="Username is mandatory")
    private String username;
    @Email(message = "Email is not formatted")
    @NotEmpty(message ="Email is mandatory")
    @NotEmpty(message ="Email is mandatory")
    private String email;
    @NotEmpty(message ="Password is mandatory")
    @NotEmpty(message ="Password is mandatory")
    @Size(min=8,message ="Password should be 8 characters long minimum")
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    @Size(min=8,message="Phone number should be 8 digits long minimum ")
    private String phoneNumber;
}
