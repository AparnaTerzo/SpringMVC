package com.example.demo.dto;
import com.example.demo.models.Authority;

import com.example.demo.models.Users;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Users users;
    private Authority authority;
}
