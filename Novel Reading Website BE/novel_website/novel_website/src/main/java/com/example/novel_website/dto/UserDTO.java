package com.example.novel_website.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.example.novel_website.enums.Gender;
import com.example.novel_website.model.Role;

import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
public class UserDTO {
    private ObjectId id; // Use ObjectId for a unique identifier

    @NotBlank
    private String name;

    @NotBlank
    private String imageURL;

    @DBRef
    @Builder.Default
    private Set<Role> roles = new HashSet<>();

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Gender gender;
    
    @NotNull
    private LocalDate joinDate;

    @NotNull
    private boolean active;
}