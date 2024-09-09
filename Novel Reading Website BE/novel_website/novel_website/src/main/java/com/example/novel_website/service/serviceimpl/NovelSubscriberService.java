package com.example.novel_website.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.model.NovelSubscriber;
import com.example.novel_website.repository.NovelSubscriberRepository;

import jakarta.annotation.PostConstruct;

@Service
public class NovelSubscriberService{
    @Autowired
    ChapterService chapterService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    NovelSubscriberRepository subscriberRepository;

    private List<NovelSubscriber> subscribers = new ArrayList<>();

    @PostConstruct
    public void init() {
        loadSubscribers();
    }

    private void loadSubscribers(){
        subscribers = subscriberRepository.findAll();
        for (NovelSubscriber subscriber : subscribers) {
            chapterService.addPropertyChangeListener(subscriber);
        }
    }

    public void subscribe(String userId, String novelName) {
        NovelSubscriber subscriber = new NovelSubscriber(new ObjectId(userId), novelName);
        NovelSubscriber savedNovelSubscriber = subscriberRepository.save(subscriber);
        chapterService.addPropertyChangeListener(savedNovelSubscriber);
    }

    public void unsubscribe(String userId, String novelName) throws ItemNotFoundException {
        NovelSubscriber subscriber = findByUserIdAndNovelName(new ObjectId(userId), novelName);
        chapterService.removePropertyChangeListener(subscriber);
        subscriberRepository.delete(subscriber);
    }

    private NovelSubscriber findByUserIdAndNovelName(ObjectId userId, String novelName) throws ItemNotFoundException {
        return subscriberRepository
                    .findByUserIdAndNovelName(userId, novelName)
                    .orElseThrow(() -> new ItemNotFoundException("Subscriber not found"));
    }

}