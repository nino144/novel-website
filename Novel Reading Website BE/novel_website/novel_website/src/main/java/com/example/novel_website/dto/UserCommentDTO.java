package com.example.novel_website.dto;

import java.util.Date;

import org.bson.types.ObjectId;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserCommentDTO {
    protected ObjectId id;

    @NotBlank
    protected String imageURL;

    @NotBlank
    protected String userName;

    @NotBlank
    protected String novelName;

    @NotNull
    protected Date time;

    @NotBlank
    protected String content;

    @NotNull
    protected ObjectId[] likeCount;

    @NotNull
    protected ObjectId[] dislikeCount;

    @NotNull
    protected int answerCount;

    @NotNull
    protected int chapterNumber;

    @NotBlank
    protected String chapterTitle;
    
    protected ObjectId parentId;

}
