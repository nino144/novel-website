package com.example.novel_website.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.novel_website.model.Novel;
import com.example.novel_website.repository.queries.NovelQueries;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface NovelRepository extends MongoRepository<Novel, String> {
    @Query(NovelQueries.FIND_BY_NAME)
    Novel findByName(@Param("name") String name);

    @Query(NovelQueries.FIND_ENABLED_NOVELS)
    Page<Novel> findEnabledNovels(Pageable pageable); 

    @Query(NovelQueries.FIND_ENABLED_NOVELS_BY_NAME)
    List<Novel> findEnabledNovelsByName(List<String> names); 

    @Query(NovelQueries.FIND_ENABLED_NOVEL_BY_NAME)
    Novel findEnabledNovelByName(@Param("name") String name); 
}