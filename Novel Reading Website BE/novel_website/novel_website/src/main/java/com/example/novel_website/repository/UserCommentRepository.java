package com.example.novel_website.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.novel_website.model.UserComment;
import com.example.novel_website.repository.queries.UserPostQueries;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserCommentRepository extends MongoRepository<UserComment, ObjectId> {
    @Query(UserPostQueries.FIND_BY_NOVEL_NAME)
    Page<UserComment> findByNovelName(String novelName, Pageable pageable);

    @Query(UserPostQueries.FIND_ALL_BY_ID)
    Page<UserComment> findAllById(ObjectId id, Pageable pageable);

    @Query(UserPostQueries.FIND_ALL_BY_ID)
    List<UserComment> findAllByIdList(ObjectId id);
}