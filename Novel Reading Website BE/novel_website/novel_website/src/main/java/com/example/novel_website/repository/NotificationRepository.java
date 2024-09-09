package com.example.novel_website.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.novel_website.model.Notification;
import com.example.novel_website.repository.queries.NotificationQueries;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, ObjectId> {
    @Query(NotificationQueries.FIND_BY_USER_ID)
    List<Notification> findByUserId(ObjectId userId);
}