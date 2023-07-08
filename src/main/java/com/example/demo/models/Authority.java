package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authority {
    @Id
    private String username;
    private String role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Users users;
}
