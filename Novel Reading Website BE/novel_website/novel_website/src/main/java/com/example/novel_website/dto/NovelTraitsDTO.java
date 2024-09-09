package com.example.novel_website.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NovelTraitsDTO {
    @NotNull
    private String wordContext;

    @NotNull
    private String vision;

    @NotNull
    private String status;

    @NotNull
    private String characterTrait;
}