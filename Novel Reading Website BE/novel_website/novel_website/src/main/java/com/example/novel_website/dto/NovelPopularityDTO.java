package com.example.novel_website.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NovelPopularityDTO {
    @NotNull
    private Integer views;

    @NotNull
    private Integer nominates;

    @NotNull
    private Integer stores;

    @NotNull
    private Double rating;
}