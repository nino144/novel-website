package com.example.novel_website.repository.queries;

public class ChapterQueries {
    public static final String FIND_ACTIVE_CHAPTER_BY_NOVEL_NAME_WITHOUT_CONTENT = "{'active': true, 'novelName': ?0}, {'content': 0}";

    public static final String FIND_BY_NOVEL_NAME_AND_CHAPTER_NUMBER = "{'novelName': ?0, 'chapterNumber': ?1}";
}
