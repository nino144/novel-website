package com.example.novel_website.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.novel_website.service.serviceimpl.NotificationService;

import lombok.Data;

@Document(collection = "subscribers")
@Data
public class NovelSubscriber implements PropertyChangeListener {
    @Id
    private ObjectId id;
    private ObjectId userId;
    private String novelName;

    protected static final Logger logger = LoggerFactory.getLogger(NovelSubscriber.class);

    public NovelSubscriber(ObjectId userId, String novelName) {
        this.userId = userId;
        this.novelName = novelName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals("chapter")) {
            Chapter newChapter = (Chapter) event.getNewValue();
            NotificationService notificationService = (NotificationService) event.getSource();
            sendNotification(newChapter, notificationService);
        }
    }

    private void sendNotification(Chapter newChapter, NotificationService notificationService) {
        notificationService.sendNotification(userId, novelName + " have 1 new chapter: " + newChapter.getChapterTitle());
    }
}