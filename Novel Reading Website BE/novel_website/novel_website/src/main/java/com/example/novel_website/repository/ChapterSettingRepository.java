package com.example.novel_website.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.novel_website.model.ChapterSetting;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterSettingRepository extends MongoRepository<ChapterSetting, ObjectId>{

    
} 