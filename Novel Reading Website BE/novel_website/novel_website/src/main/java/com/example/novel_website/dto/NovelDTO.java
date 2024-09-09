package com.example.novel_website.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NovelDTO {
    private String name;

    private String imageURL;

    @NotBlank
    private String description;

    @NotBlank
    private String author;

    @NotBlank
    private String category;

    @NotBlank
    private Integer chapter;

    @NotNull
    private boolean active;

    private NovelPopularityDTO novelPopularity;
    
    private NovelTraitsDTO novelTraits;
}
