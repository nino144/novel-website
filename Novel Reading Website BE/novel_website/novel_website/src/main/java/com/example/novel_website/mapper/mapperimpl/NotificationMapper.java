package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.NotificationDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Notification;

@Component
public class NotificationMapper implements Mapper<NotificationDTO, Notification> {
    private static final Logger logger = LoggerFactory.getLogger(NotificationMapper.class);

    @Override
    public NotificationDTO convertToDTO(Notification notification) {
        logger.debug("Converting entity to DTO: {}", notification);

        NotificationDTO notificationDTO = NotificationDTO.builder()
                .id(notification.getId()) // Convert ObjectId to String
                .userId(notification.getUserId())
                .content(notification.getContent())
                .sentAt(notification.getSentAt())
                .seen(notification.isSeen())
                .build();

        logger.debug("Converted entity to DTO: {}", notificationDTO);
        return notificationDTO;
    }

    @Override
    public Notification convertToEntity(NotificationDTO notificationDTO) {
        logger.debug("Converting DTO to entity: {}", notificationDTO);
        
        Notification notification = Notification.builder()
                .id(notificationDTO.getId()) // Convert ObjectId to String
                .userId(notificationDTO.getUserId())
                .content(notificationDTO.getContent())
                .sentAt(notificationDTO.getSentAt())
                .seen(notificationDTO.isSeen())
                .build();

        logger.debug("Converted DTO to entity: {}", notification);
        return notification;
    }
}
