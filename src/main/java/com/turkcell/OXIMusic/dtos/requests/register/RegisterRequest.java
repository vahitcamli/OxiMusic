package com.turkcell.OXIMusic.dtos.requests.register;

import java.time.LocalDateTime;

import com.turkcell.OXIMusic.entities.enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String surName;
    
    private LocalDateTime birthDate;
    
    private Gender gender;
    
    
}
