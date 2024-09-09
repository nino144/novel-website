package com.example.novel_website.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NovelTraits {
    private String wordContext;
    private String vision;
    private String status;
    private String characterTrait;
}