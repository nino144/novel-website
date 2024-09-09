package com.example.novel_website.repository.queries;

public class UserPostQueries {
    //public static final String FIND_BY_NOVEL_NAME = "{'novelName' : { $regex: ?0, $options: 'i' }}";
    public static final String FIND_BY_NOVEL_NAME = "{'novelName': ?0, 'parentId': null}";

    public static final String FIND_ALL_BY_ID = "{'parentId': ?0}";

}
