package com.example.novel_website.repository;

import com.example.novel_website.repository.queries.UserPostQueries;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.novel_website.model.UserDiscussion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserDiscussionRepository extends MongoRepository<UserDiscussion, ObjectId> {
    @Query(UserPostQueries.FIND_BY_NOVEL_NAME)
    Page<UserDiscussion> findByNovelName(String novelName, Pageable pageable);

    @Query(UserPostQueries.FIND_ALL_BY_ID)
    Page<UserDiscussion> findAllById(ObjectId id, Pageable pageable);

    @Query(UserPostQueries.FIND_ALL_BY_ID)
    List<UserDiscussion> findAllByIdList(ObjectId id);
}