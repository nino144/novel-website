package com.example.novel_website.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.novel_website.model.ReadProgress;
import com.example.novel_website.repository.queries.ReadProgressQueries;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ReadProgressRepository extends MongoRepository<ReadProgress, ObjectId>{
    @Query(ReadProgressQueries.FIND_BY_USER_ID_IS_CURRENTLY_READING)
    Page<ReadProgress> findByUserIdIsCurrentlyReading(ObjectId userId, Pageable pageable);

    @Query(ReadProgressQueries.FIND_BY_USER_ID_AND_IS_MARKED)
    Page<ReadProgress> findByUserIdAndIsMarked(ObjectId userId, Pageable pageable);

    @Query(ReadProgressQueries.EXISTS_BY_NOVEL_NAME_AND_USER_ID_AND_CHAPTER)
    ReadProgress existsByNovelNameAndUserIdAndChapter(String novelName, ObjectId userId, Integer chapter);

    @Query(ReadProgressQueries.FIND_BY_USER_ID)
    Page<ReadProgress> findByUserId(ObjectId userId, Pageable pageable);
}
