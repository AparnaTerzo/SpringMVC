package com.example.demo.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private Long id;
    @NotEmpty(message = "name must be filled")
    private String name;
    @NotEmpty(message = "email is mandatory")
    private String email;
    @NotEmpty(message = "designation must be filled")
    private String designation;
    private Long mobile;
    private String address;
    private String department;
}
