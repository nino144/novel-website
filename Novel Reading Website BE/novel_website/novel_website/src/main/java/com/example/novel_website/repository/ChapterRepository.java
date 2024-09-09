package com.example.novel_website.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.novel_website.model.Chapter;
import com.example.novel_website.repository.queries.ChapterQueries;

@Repository
public interface ChapterRepository extends MongoRepository<Chapter, ObjectId> {
    @Query(ChapterQueries.FIND_BY_NOVEL_NAME_AND_CHAPTER_NUMBER)
    Optional<Chapter> findByNovelNameAndChapterNumber(String novelName, Integer chapterNumber);

    @Query(ChapterQueries.FIND_ACTIVE_CHAPTER_BY_NOVEL_NAME_WITHOUT_CONTENT)
    List<Chapter> findOverviewsByNovelName(@Param("novelName") String novelName);
}
