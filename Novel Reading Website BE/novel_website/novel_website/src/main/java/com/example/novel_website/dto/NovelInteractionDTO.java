package com.example.novel_website.dto;

import java.time.LocalDate;

import com.example.novel_website.enums.Interaction;

import lombok.Data;

@Data
public class NovelInteractionDTO {
    
    private String novelName;

    private LocalDate dateMark;

    private Interaction interactionType;

    private String value;
    
}