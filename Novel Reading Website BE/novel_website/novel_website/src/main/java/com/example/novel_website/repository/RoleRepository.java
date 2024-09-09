package com.example.novel_website.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.novel_website.enums.ERole;
import com.example.novel_website.model.Role;

public interface RoleRepository extends MongoRepository<Role, ObjectId>{
    Role findByName(ERole roleUser);
}
