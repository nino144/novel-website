package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.UserCommentDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.UserComment;

@Component
public class UserCommentMapper implements Mapper<UserCommentDTO, UserComment>{
    private static final Logger logger = LoggerFactory.getLogger(UserComment.class);

    @Override
    public UserCommentDTO convertToDTO(UserComment userComment) {
        logger.debug("Converting entity to DTO: {}", userComment);

        UserCommentDTO userCommentDTO = UserCommentDTO.builder()
                .id(userComment.getId()) // Convert ObjectId to String
                .imageURL(userComment.getImageURL())
                .userName(userComment.getUserName())
                .novelName(userComment.getNovelName())
                .time(userComment.getTime())
                .content(userComment.getContent())
                .likeCount(userComment.getLikeCount())
                .dislikeCount(userComment.getDislikeCount())
                .answerCount(userComment.getAnswerCount())
                .chapterNumber(userComment.getChapterNumber())
                .chapterTitle(userComment.getChapterTitle())
                //.depth(userComment.getDepth())
                //.parentId(userComment.getParentId())
                .parentId(userComment.getParentId() != null ? userComment.getParentId() : null)
                .build();

        logger.debug("Converted entity to DTO: {}", userCommentDTO);
        return userCommentDTO;
    }

    @Override
    public UserComment convertToEntity(UserCommentDTO userCommentDTO) {
        logger.debug("Converting DTO to entity: {}", userCommentDTO);
        
        UserComment userComment = UserComment.builder()
                .id(userCommentDTO.getId()) // Convert ObjectId to String
                .imageURL(userCommentDTO.getImageURL())
                .userName(userCommentDTO.getUserName())
                .novelName(userCommentDTO.getNovelName())
                .time(userCommentDTO.getTime())
                .content(userCommentDTO.getContent())
                .likeCount(userCommentDTO.getLikeCount())
                .dislikeCount(userCommentDTO.getDislikeCount())
                .answerCount(userCommentDTO.getAnswerCount())
                .chapterNumber(userCommentDTO.getChapterNumber())
                .chapterTitle(userCommentDTO.getChapterTitle())
                //.depth(userCommentDTO.getDepth())
                //.parentId(userCommentDTO.getParentId())
                .parentId(userCommentDTO.getParentId() != null ? userCommentDTO.getParentId() : null)
                .build();

        logger.debug("Converted DTO to entity: {}", userComment);
        return userComment;
    }
}
