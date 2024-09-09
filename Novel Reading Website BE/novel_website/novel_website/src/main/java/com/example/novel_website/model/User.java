package com.example.novel_website.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.novel_website.enums.Gender;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "user") // Specify the MongoDB collection name
@Builder
public class User{
    @Id
    private ObjectId id; // Use ObjectId for a unique identifier

    @Indexed(unique = true)
    @NonNull
    private String name;
    private String imageURL;
    
    @DBRef
    @Builder.Default
    private Set<Role> roles = new HashSet<>();
    
    @Indexed(unique = true)
    @NonNull
    private String email;
    
    private String password;
    private LocalDate dateOfBirth;
    private Gender gender;
    private LocalDate joinDate;
    private boolean active;
    
    public User(){}
    public User(String name, String email, String encode) {
        this.name = name;
        this.imageURL = "ranom.jpg";
        this.roles = new HashSet<>();
        this.email = email;
        this.password = encode;
        this.dateOfBirth = LocalDate.now();
        this.gender = Gender.FEMALE;
        this.joinDate = LocalDate.now();
        this.active = true;
    }

    public User(ObjectId id, String name, String imageURL, Set<Role> roles, String email, String password, LocalDate dateOfBirth, Gender gender, LocalDate joinDate, boolean active) {
        this.id = id;
        this.name = name;
        this.imageURL = imageURL;
        this.roles = roles;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.joinDate = joinDate;
        this.active = active;
    }
    
}
