package com.example.novel_website.repository.queries;

public class NovelSubscriberQueries {
    public static final String FIND_BY_NOVEL_NAME = "{'novelName': ?0}";
    
    public static final String FIND_BY_USER_ID_AND_NOVEL_NAME = "{'userId': ?0, 'novelName': ?1}";
}