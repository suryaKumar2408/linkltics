package com.surya.linkltics_backend.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequest {
    private String username;
    private String email;
    private Set<String> role;
    private String password;
}
