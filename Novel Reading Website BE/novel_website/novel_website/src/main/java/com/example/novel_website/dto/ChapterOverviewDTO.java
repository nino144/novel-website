package com.example.novel_website.dto;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChapterOverviewDTO {
    private ObjectId id;
    private String novelName;
    private Integer chapterNumber;
    private String chapterTitle;
    private LocalDate publishDate;
    private boolean active;

}

