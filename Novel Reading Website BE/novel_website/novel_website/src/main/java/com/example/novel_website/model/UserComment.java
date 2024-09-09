package com.example.novel_website.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Builder;

@Data
@Document(collection = "userComment") // Specify the MongoDB collection name
@Builder
public class UserComment {
    @Id
    protected ObjectId id;
    protected String imageURL;
    protected String userName;
    protected String novelName;
    protected Date time;
    protected String content;
    protected ObjectId[] likeCount;
    protected ObjectId[] dislikeCount;
    protected int answerCount;
    protected int chapterNumber;
    protected String chapterTitle;
    protected ObjectId parentId;     

    //public UserComment() {}
}
