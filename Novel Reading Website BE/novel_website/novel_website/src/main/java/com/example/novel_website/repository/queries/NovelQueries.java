package com.example.novel_website.repository.queries;

public class NovelQueries {
    public static final String FIND_BY_NAME = "{'name' : { $regex: ?0, $options: 'i' }}";

    public static final String FIND_ENABLED_NOVELS = "{'active': true}";

    public static final String FIND_ENABLED_NOVELS_BY_NAME = "{'name': {$in: ?0}, 'active': true}", fields = "{'_id': 0}";

    public static final String FIND_ENABLED_NOVEL_BY_NAME = "{'name' : { $regex: ?0, $options: 'i' } , 'active' : true}";

}
