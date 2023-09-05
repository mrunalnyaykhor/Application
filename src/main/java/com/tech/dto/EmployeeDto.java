package com.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @NotBlank(message = "Please enter proper employee name")
    @Size(min=2, message = "Name should be atleast 5 characters")
    @Size(max=12, message = "Name should not be greater than 12 characters")
    private String employeeName;
    @NotBlank(message = "Please enter proper employee Address")
    @Size( message = "Address should be atleast 50 characters")
    @Size( message = "Address should not be greater than 60 characters")
    private String employeeAddress;
    @NotNull(message = "Please enter a valid contact Number")
//    @Size( message = "ContactNumber should be atleast 10 characters")
//    @Size( message = "ContactNumber should not be greater than 10 characters")
    private Long employeeContactNumber;
    @Email(message = "Please enter a valid email Id", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
    @NotNull(message = "Please enter a valid email Id")
    private String employeeEmailId;
}
