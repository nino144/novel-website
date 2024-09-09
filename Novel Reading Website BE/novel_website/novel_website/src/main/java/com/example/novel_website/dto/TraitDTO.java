package com.example.novel_website.dto;

import org.bson.types.ObjectId;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@Builder
public class TraitDTO {

  private ObjectId id; // Use String for the ID in the DTO

  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotBlank
  private String value;

  @NotNull
  private boolean active;
}