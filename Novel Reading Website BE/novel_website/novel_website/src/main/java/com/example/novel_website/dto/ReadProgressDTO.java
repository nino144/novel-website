package com.example.novel_website.dto;

import org.bson.types.ObjectId;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadProgressDTO {
    private ObjectId id;

    @NotBlank
    private String novelName;

    @NotNull
    private ObjectId userId;

    @NotBlank
    private String imageURL;

    @NotBlank
    private String chapterTitle;

    @NotNull
    private Integer chapter;

    @NotBlank
    private String time;

    @NotNull
    private boolean marked;

    @NotNull
    private boolean currentlyReading;

}
