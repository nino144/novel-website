package com.example.novel_website.model;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "novels") // Specify the MongoDB collection name
@Builder
public class Novel {
    @Id
    private String name;
    private String imageURL;
    private String description;
    private String author;
    private String category;
    private Integer chapter;
    private boolean active;
    private NovelPopularity novelPopularity;
    private NovelTraits novelTraits;
}
