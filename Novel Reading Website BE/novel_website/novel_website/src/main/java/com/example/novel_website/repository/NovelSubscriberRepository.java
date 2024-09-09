package com.example.novel_website.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.novel_website.model.NovelSubscriber;

import com.example.novel_website.repository.queries.NovelSubscriberQueries;

@Repository
public interface NovelSubscriberRepository extends MongoRepository<NovelSubscriber, ObjectId> {
    @Query(NovelSubscriberQueries.FIND_BY_NOVEL_NAME)
    List<NovelSubscriber> findByNovelName(String novelName);

    @Query(NovelSubscriberQueries.FIND_BY_USER_ID_AND_NOVEL_NAME)
    Optional<NovelSubscriber> findByUserIdAndNovelName(ObjectId userId, String novelName);
}
