package com.example.novel_website.service.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.UserCommentDTO;
import com.example.novel_website.dto.UserDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.UserComment;
import com.example.novel_website.repository.UserCommentRepository;
import com.example.novel_website.util.UsernameExtractionUtil;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserCommentService {
    @Autowired
    protected Mapper<UserCommentDTO, UserComment> mapper;

    @Autowired
    NotificationService notificationService;

    @Autowired
    private UserService userService;

    protected static final Logger logger = LoggerFactory.getLogger(UserCommentService.class);

    @Autowired
    protected UserCommentRepository repository; // Renamed to PostRepository

    public List<UserCommentDTO> findByNovelName(String novelName, Pageable pageable) throws InterruptedException{
        logger.debug("Finding user comments");

        Page<UserComment> userCommentsPage = repository.findByNovelName(novelName, pageable);
        Page<UserCommentDTO> userCommentsDTOPage = userCommentsPage.map(mapper::convertToDTO);
        List<UserCommentDTO> userCommentsDTOList = userCommentsDTOPage.getContent();

        logger.debug("Found user comments: {}", userCommentsDTOList);
        return userCommentsDTOList;
    }

    public List<UserCommentDTO> findSubComments(String parentId, Pageable pageable) throws InterruptedException {
        logger.debug("Finding sub comments");

        Page<UserComment> subCommentsPage = repository.findAllById(new ObjectId(parentId), pageable);
        Page<UserCommentDTO> subCommentsDTOPage = subCommentsPage.map(mapper::convertToDTO);
        List<UserCommentDTO> subCommentsDTOList = subCommentsDTOPage.getContent();

        logger.debug("Found sub comments: {}", subCommentsDTOList);
        return subCommentsDTOList;
    }

    public UserCommentDTO create(UserCommentDTO userCommentDTO) throws ItemNotFoundException {
        logger.info("Creating User Comment: {}", userCommentDTO);
        UserComment comment = mapper.convertToEntity(userCommentDTO); 
        processReferenceUsernames(comment.getUserName(), comment.getNovelName(), comment.getTime(), comment.getContent());
        UserComment savedComment = repository.save(comment); // Save the post as a top-level post
        return mapper.convertToDTO(savedComment);
    }

    private void processReferenceUsernames(String userName, String novelName, Date time, String content) throws ItemNotFoundException {
      List<String> mentionedUsernames = UsernameExtractionUtil.extractUsernames(content);
  
      if (!mentionedUsernames.isEmpty()) {
          handleExtractedUsernames(userName, novelName, time, mentionedUsernames);
      }
  }

  public void handleExtractedUsernames(String userName, String novelName, Date time, List<String> usernames) throws ItemNotFoundException {
    for (String username : usernames) {
        UserDTO userDTO = userService.findByName(username);
        
        String message = userName + " mentioned you in the novel " + novelName + " at " + time.toString();
        notificationService.sendNotification(userDTO.getId(), message);
    }
}

  public void likeComment(String userId, String commentId) throws ItemNotFoundException { // Renamed likeComment to likePost
    logger.info("Liking comment: {} by user: {}", commentId, userId);
    UserComment comment = findCommentById(commentId); // Renamed findCommentById to findPostById
    updateLikeCount(comment, userId, true);
    updateDislikeCount(comment, userId, false);
    repository.save(comment);
    logger.info("Successfully liked comment: {}", commentId);
  }

    public void dislikeComment(String userId, String commentId) throws ItemNotFoundException { // Renamed dislikeComment to dislikePost
        logger.info("Disliking comment : {} by user: {}", commentId, userId);
        UserComment comment = findCommentById(commentId); 
        updateLikeCount(comment , userId, false);
        updateDislikeCount(comment , userId, true);
        repository.save(comment);
        logger.info("Successfully disliked comment : {}", commentId);
    }
    
    private void updateLikeCount(UserComment comment , String userId, boolean isLike) {
        logger.info("Updating like count for user comment : {}", comment .getId());
        List<ObjectId> likeCountList = new ArrayList<>(Arrays.asList(comment .getLikeCount()));
        boolean alreadyLiked = likeCountList.contains(new ObjectId(userId));
      
        if (isLike) {
          if (!alreadyLiked) {
            likeCountList.add(new ObjectId(userId));
          } else {
            likeCountList.remove(new ObjectId(userId));
          }
        } else if (!isLike && alreadyLiked) {
          likeCountList.remove(new ObjectId(userId));
        }
      
        comment .setLikeCount(likeCountList.toArray(new ObjectId[0]));
        logger.info("Updated like count for user comment : {}", comment .getId());
      }
      
      private void updateDislikeCount(UserComment comment, String userId, boolean isDislike) {
        logger.info("Updating dislike count for user comment: {}", comment.getId());
        List<ObjectId> dislikeCountList = new ArrayList<>(Arrays.asList(comment.getDislikeCount()));
        boolean alreadyDisliked = dislikeCountList.contains(new ObjectId(userId));
      
        if (isDislike) {
          if (!alreadyDisliked) {
            dislikeCountList.add(new ObjectId(userId));
          } else {
            dislikeCountList.remove(new ObjectId(userId));
          }
        } else if (!isDislike && alreadyDisliked) {
          dislikeCountList.remove(new ObjectId(userId));
        }
      
        comment.setDislikeCount(dislikeCountList.toArray(new ObjectId[0]));
        logger.info("Updated dislike count for user comment: {}", comment.getId());
      }
      
      private UserComment findCommentById(String commentId) throws ItemNotFoundException {
        logger.info("Finding user comment by id: {}", commentId);
        UserComment comment = repository.findById(new ObjectId(commentId))
            .orElseThrow(() -> new ItemNotFoundException("User comment not found"));
        logger.info("Found user comment with id: {}", commentId);
        return comment;
      }
      
      public void deleteComment(String commentId) throws ItemNotFoundException {
        logger.info("Deleting user comment: {}", commentId);
        UserComment comment = findCommentById(commentId);
        deleteSubComments(new ObjectId(commentId));
        repository.delete(comment);
        logger.info("Successfully deleted user comment: {}", commentId);
      }
      
      private void deleteSubComments(ObjectId id) {
        logger.info("Deleting sub-comments for user comment: {}", id);
        List<UserComment> comments = repository.findAllByIdList(id);
        if (comments != null) {
          repository.deleteAll(comments);
        }
    }
}
