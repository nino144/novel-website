package com.example.novel_website.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameExtractionUtil {
    public static List<String> extractUsernames(String message) {
        List<String> usernames = new ArrayList<>();
        String regex = "@(\\w+)(\\s|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);

        while (matcher.find()) {
            usernames.add(matcher.group(1));
        }

        return usernames;
    }
}
