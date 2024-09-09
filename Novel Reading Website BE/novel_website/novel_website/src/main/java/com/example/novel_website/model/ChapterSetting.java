package com.example.novel_website.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Document(collection = "ChapterSetting") // Specify the MongoDB collection name
@Builder
public class ChapterSetting {
    @Id
    private ObjectId userId;

    private String font;

    private String fontSize;

    private String lineHeight;

    private String align;

    private String color;

    private String backgroundColor;

    public ChapterSetting() {}

    public ChapterSetting(ObjectId userId) {
        this.userId = userId;
        this.font = "Avenir Next";
        this.fontSize = "14px";
        this.lineHeight = "110%";
        this.align = "center";
        this.color = "#FF5733";
        this.backgroundColor = "#FFFFFF";
    }
    
    public ChapterSetting(ObjectId userId, String font, String fontSize, String lineHeight, String align, String color, String backgroundColor) {
        this.userId = userId;
        this.font = font;
        this.fontSize = fontSize;
        this.lineHeight = lineHeight;
        this.align = align;
        this.color = color;
        this.backgroundColor = backgroundColor;
    }
}
