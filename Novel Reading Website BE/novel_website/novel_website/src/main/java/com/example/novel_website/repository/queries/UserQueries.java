package com.example.novel_website.repository.queries;

public class UserQueries {
    public static final String FIND_ENABLED_USERS = "{'active': true}";

    public static final String FIND_BY_EMAIL_AND_IS_ACTIVE = "{'email': ?0, 'active': true}";

    public static final String FIND_BY_NAME = "{'name': ?0}";

    public static final String FIND_ALL_USERS = "{}"; // This retrieves all users

}
