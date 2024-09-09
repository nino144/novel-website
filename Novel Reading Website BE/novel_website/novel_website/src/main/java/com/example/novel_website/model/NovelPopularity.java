package com.example.novel_website.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NovelPopularity {
    @Builder.Default
    private Integer views = 0;

    @Builder.Default
    private Integer nominates = 0;

    @Builder.Default
    private Integer stores = 0;

    @Builder.Default
    private Double rating = 0.0;
}