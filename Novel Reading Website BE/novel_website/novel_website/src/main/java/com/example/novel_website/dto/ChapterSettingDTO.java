package com.example.novel_website.dto;

import org.bson.types.ObjectId;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChapterSettingDTO {
    private ObjectId userId;

    @NotBlank
    private String font;

    @NotBlank
    private String fontSize;

    @NotBlank
    private String lineHeight;

    @NotBlank
    private String align;

    @NotBlank
    private String color;

    @NotBlank
    private String backgroundColor;
}
