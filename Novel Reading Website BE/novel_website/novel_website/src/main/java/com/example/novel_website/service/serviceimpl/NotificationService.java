package com.example.novel_website.service.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.NotificationDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Notification;
import com.example.novel_website.repository.NotificationRepository;

@Service
public class NotificationService{
    @Autowired
    protected MongoRepository<Notification, ObjectId> repository; // Use MongoRepository

    @Autowired
    Mapper<NotificationDTO, Notification> mapper;

    protected static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void sendNotification(ObjectId userId, String content) {
        Notification notification = makeNewNotification(userId, content);
        repository.save(notification);
    }

    public List<NotificationDTO> findByUserId(ObjectId userId) 
                                    throws InterruptedException{
        logger.debug("Finding Notifications");

        List<Notification> notifications = ((NotificationRepository) repository).findByUserId(userId);

        logger.debug("Found Notifications: {}", notifications);
        return convertToDTOs(notifications);
    }

    public NotificationDTO update(String id) throws ItemNotFoundException {
        logger.debug("change notifcation state");
    
        Notification notification = changeNoticationState(id);
        Notification updatedNotification = repository.save(notification);
        logger.debug("Updated Notification successfully: {}", updatedNotification);
    
        return mapper.convertToDTO(updatedNotification);
    }

    private Notification changeNoticationState(String id) throws ItemNotFoundException {
        Notification notification = findById(new ObjectId(id));
        notification.setSeen(true);
        return notification;
    }

    private List<NotificationDTO> convertToDTOs(List<Notification> notifications) {
        return notifications.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }

    private Notification makeNewNotification(ObjectId userId, String content) {
        return Notification.builder()
            .userId(userId)
            .content(content)
            .sentAt(LocalDate.now())
            .build();
    }

    private Notification findById(ObjectId id) throws ItemNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Notification not found"));
    }
}
