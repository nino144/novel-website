package com.example.novel_website.repository;

import com.example.novel_website.enums.Interaction;
import com.example.novel_website.model.NovelInteraction;
import com.example.novel_website.repository.queries.NovelInteractionQueries;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelInteractionRepository extends MongoRepository<NovelInteraction, ObjectId> {
    @Query(NovelInteractionQueries.FIND_RECORD)
    NovelInteraction findRecord(
                        @Param("novelName") String novelName, 
                        @Param("dateMark") LocalDate dateMark,
                        @Param("interactionType") Interaction interactionType
    );

    @Query(NovelInteractionQueries.FIND_NOVEL_NAME_BY_INTERACTION_TYPE_AND_DATE)
    List<NovelInteraction> findNovelNameByInteractionTypeAndDateMark(Interaction interactionType, LocalDate startDate, LocalDate endDat);

}