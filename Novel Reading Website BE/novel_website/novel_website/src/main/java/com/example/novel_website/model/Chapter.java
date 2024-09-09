package com.example.novel_website.model;

import java.time.LocalDate;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "Chapter") // Specify the MongoDB collection name
@Builder
public class Chapter{    
    @Id
    private ObjectId id;
    private String novelName;
    private Integer chapterNumber;
    private String chapterTitle;
    private String content;
    private LocalDate publishDate;
    private boolean active;
}
