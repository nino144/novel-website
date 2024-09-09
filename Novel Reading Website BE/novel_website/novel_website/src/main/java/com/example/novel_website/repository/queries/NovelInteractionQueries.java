package com.example.novel_website.repository.queries;

public class NovelInteractionQueries {
    public static final String FIND_RECORD =  "{ 'novelName': ?0, 'dateMark': ?1, 'interactionType': ?2}";

    public static final String FIND_NOVEL_NAME_BY_INTERACTION_TYPE_AND_DATE = 
                "{'interactionType': ?0, 'dateMark': { $gte: ?1, $lte: ?2 }}", fields = "{'novelName': 1}";
}
