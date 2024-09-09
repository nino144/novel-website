package com.example.novel_website.model;

import java.time.LocalDate;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.novel_website.enums.Interaction;

import lombok.Data;

@Data
@Document(collection = "interaction") // Specify the MongoDB collection name
public class NovelInteraction {
    @Id
    private ObjectId id; // Use ObjectId for a unique identifier

    private String novelName;

    private LocalDate dateMark;

    private Interaction interactionType;

    private String value;

    public NovelInteraction(String novelName, LocalDate dateMark, Interaction interactionType, String value) {
        this.novelName = novelName;
        this.dateMark = dateMark;
        this.interactionType = interactionType;
        this.value = value;
    }
    
}
