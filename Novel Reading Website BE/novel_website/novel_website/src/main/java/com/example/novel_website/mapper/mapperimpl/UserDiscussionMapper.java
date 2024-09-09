package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.UserDiscussionDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.UserDiscussion;

@Component
public class UserDiscussionMapper  implements Mapper<UserDiscussionDTO, UserDiscussion>{
    private static final Logger logger = LoggerFactory.getLogger(UserDiscussion.class);

    @Override
    public UserDiscussionDTO convertToDTO(UserDiscussion userDiscussion) {
        logger.debug("Converting entity to DTO: {}", userDiscussion);

        UserDiscussionDTO userDiscussionDTO = UserDiscussionDTO.builder()
                .id(userDiscussion.getId()) // Convert ObjectId to String
                .imageURL(userDiscussion.getImageURL())
                .userName(userDiscussion.getUserName())
                .novelName(userDiscussion.getNovelName())
                .time(userDiscussion.getTime())
                .content(userDiscussion.getContent())
                .likeCount(userDiscussion.getLikeCount())
                .dislikeCount(userDiscussion.getDislikeCount())
                .answerCount(userDiscussion.getAnswerCount())
                .chapterNumber(userDiscussion.getChapterNumber())
                .chapterTitle(userDiscussion.getChapterTitle())
                //.depth(userDiscussion.getDepth())
                //.parentId(userDiscussion.getParentId())
                .parentId(userDiscussion.getParentId() != null ? userDiscussion.getParentId() : null)
                .rating(((UserDiscussion) userDiscussion).getRating()) // Cast to UserDiscussion to access rating
                .build();

        logger.debug("Converted entity to DTO: {}", userDiscussionDTO);
        return userDiscussionDTO;
    }

    @Override
    public UserDiscussion convertToEntity(UserDiscussionDTO userDiscussionDTO) {
        logger.debug("Converting DTO to entity: {}", userDiscussionDTO);
        
        UserDiscussion userDiscussion = UserDiscussion.builder()
                .id(userDiscussionDTO.getId()) // Convert ObjectId to String
                .imageURL(userDiscussionDTO.getImageURL())
                .userName(userDiscussionDTO.getUserName())
                .novelName(userDiscussionDTO.getNovelName())
                .time(userDiscussionDTO.getTime())
                .content(userDiscussionDTO.getContent())
                .likeCount(userDiscussionDTO.getLikeCount())
                .dislikeCount(userDiscussionDTO.getDislikeCount())
                .answerCount(userDiscussionDTO.getAnswerCount())
                .chapterNumber(userDiscussionDTO.getChapterNumber())
                .chapterTitle(userDiscussionDTO.getChapterTitle())
                //.depth(userDiscussionDTO.getDepth())
                //.parentId(userDiscussionDTO.getParentId())
                .parentId(userDiscussionDTO.getParentId() != null ? userDiscussionDTO.getParentId() : null)
                .rating(((UserDiscussionDTO) userDiscussionDTO).getRating()) // Cast to UserDiscussion to access rating
                .build();

        logger.debug("Converted DTO to entity: {}", userDiscussion);
        return userDiscussion;
    }
}
