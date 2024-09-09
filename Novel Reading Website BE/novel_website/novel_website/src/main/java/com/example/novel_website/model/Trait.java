package com.example.novel_website.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "trait") // Specify the MongoDB collection name
@Builder
public class Trait {
    @Id
    private ObjectId id; // Use ObjectId for a unique identifier

    private String name;
    private String description;
    private String value;
    private boolean active;


}
