package com.example.novel_website.repository.queries;

public class ReadProgressQueries {
    public static final String FIND_BY_USER_ID_IS_CURRENTLY_READING = "{'userId': ?0, 'currentlyReading': true}";
    public static final String FIND_BY_USER_ID_AND_IS_MARKED = "{'userId': ?0, 'marked': true}";
    public static final String EXISTS_BY_NOVEL_NAME_AND_USER_ID_AND_CHAPTER = "{'novelName': ?0, 'userId': ?1, 'chapter': ?2}";
    public static final String FIND_BY_USER_ID = "{'userId': ?0}";

}
