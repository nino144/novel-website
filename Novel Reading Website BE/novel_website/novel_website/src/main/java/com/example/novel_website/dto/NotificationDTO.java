package com.example.novel_website.dto;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationDTO {
    private ObjectId id;
    private ObjectId userId;
    private String content;
    private LocalDate sentAt;
    private boolean seen;
}
