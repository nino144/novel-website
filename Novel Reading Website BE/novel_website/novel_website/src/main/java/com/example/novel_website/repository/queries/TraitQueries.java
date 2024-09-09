package com.example.novel_website.repository.queries;

public class TraitQueries {
    public static final String FIND_BY_NAME = "{'name' : { $regex: ?0, $options: 'i' }}";

    public static final String FIND_ENABLED_TRAITS = "{'active': true}";

}
