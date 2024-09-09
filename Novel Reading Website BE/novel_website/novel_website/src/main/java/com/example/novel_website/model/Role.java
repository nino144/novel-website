package com.example.novel_website.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.novel_website.enums.ERole;

import lombok.Data;

@Document(collection = "roles")
@Data
public class Role {
  @Id
  private ObjectId id;

  private ERole name;

  public Role() {}

  public Role(ERole name) {
    this.name = name;
  }

}