package com.example.novel_website.model;

import lombok.Builder;
import lombok.Data;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ReadProgress") // Specify the MongoDB collection name
@Builder
public class ReadProgress {
    @Id
    private ObjectId id;

    private String novelName;
    private ObjectId userId;
    private String imageURL;
    private String chapterTitle;
    private Integer chapter;
    private String time;
    private boolean marked;
    private boolean currentlyReading;
}