package com.example.novel_website.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "notifications")
@Builder
public class Notification {
    @Id
    private ObjectId id;
    private ObjectId userId;
    private String content;
    private LocalDate sentAt;
    private boolean seen;
}