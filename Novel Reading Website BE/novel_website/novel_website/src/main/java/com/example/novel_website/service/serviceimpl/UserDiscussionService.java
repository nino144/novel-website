package com.example.novel_website.service.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.UserDiscussionDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.UserDiscussion;
import com.example.novel_website.repository.UserDiscussionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserDiscussionService {
    @Autowired
    protected Mapper<UserDiscussionDTO, UserDiscussion> mapper;

    protected static final Logger logger = LoggerFactory.getLogger(UserDiscussionService.class);

    @Autowired
    protected UserDiscussionRepository repository;

    public List<UserDiscussionDTO> findByNovelName(String novelName, Pageable pageable) throws InterruptedException{
        logger.debug("Finding user discussions");

        Page<UserDiscussion> userDiscussionsPage = repository.findByNovelName(novelName, pageable);
        Page<UserDiscussionDTO> userDiscussionsDTOPage = userDiscussionsPage.map(mapper::convertToDTO);
        List<UserDiscussionDTO> userDiscussionsDTOList = userDiscussionsDTOPage.getContent();

        logger.debug("Found user discussions: {}", userDiscussionsDTOList);
        return userDiscussionsDTOList;
    }

    public List<UserDiscussionDTO> findSubDiscussions(String parentId, Pageable pageable) throws InterruptedException {
        logger.debug("Finding sub discussions");

        Page<UserDiscussion> subDiscussionsPage = repository.findAllById(new ObjectId(parentId), pageable);
        Page<UserDiscussionDTO> subDiscussionsDTOPage = subDiscussionsPage.map(mapper::convertToDTO);
        List<UserDiscussionDTO> subDiscussionsDTOList = subDiscussionsDTOPage.getContent();
        logger.debug("Found sub discussions: {}", subDiscussionsDTOList);

        return subDiscussionsDTOList;
    }

    public UserDiscussionDTO create(UserDiscussionDTO userDiscussionDTO) throws ItemNotFoundException {
        logger.info("Creating User Discussion: {}", userDiscussionDTO);
        UserDiscussion discussion = mapper.convertToEntity(userDiscussionDTO);
        UserDiscussion savedDiscussion = repository.save(discussion);
        return mapper.convertToDTO(savedDiscussion);
    }

    // private List<UserDiscussionDTO> convertToDTOs(List<UserDiscussion> userDiscussions) {
    //     logger.info("Converting {} user discussions to DTOs", userDiscussions.size());
    //     return userDiscussions.stream()
    //             .map(mapper::convertToDTO)
    //             .collect(Collectors.toList());
    // }

    public void likeDiscussion(String userId, String discussionId) throws ItemNotFoundException {
        logger.info("Liking discussion: {} by user: {}", discussionId, userId);

        UserDiscussion discussion = findDiscussionById(discussionId);
        updateLikeCount(discussion, userId, true);
        updateDislikeCount(discussion, userId, false);
        repository.save(discussion);

        logger.info("Successfully liked discussion: {}", discussionId);
    }

    public void dislikeDiscussion(String userId, String discussionId) throws ItemNotFoundException {
        logger.info("Disliking discussion: {} by user: {}", discussionId, userId);

        UserDiscussion discussion = findDiscussionById(discussionId);
        updateLikeCount(discussion, userId, false);
        updateDislikeCount(discussion, userId, true);
        repository.save(discussion);

        logger.info("Successfully disliked discussion: {}", discussionId);
    }

    private void updateLikeCount(UserDiscussion discussion, String userId, boolean isLike) {
        logger.info("Updating like count for user discussion: {}", discussion.getId());

        List<ObjectId> likeCountList = new ArrayList<>(Arrays.asList(discussion.getLikeCount()));
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

        discussion.setLikeCount(likeCountList.toArray(new ObjectId[0]));
        logger.info("Updated like count for user discussion: {}", discussion.getId());
      }

      private void updateDislikeCount(UserDiscussion discussion, String userId, boolean isDislike) {
        logger.info("Updating dislike count for user discussion: {}", discussion.getId());
        List<ObjectId> dislikeCountList = new ArrayList<>(Arrays.asList(discussion.getDislikeCount()));
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

        discussion.setDislikeCount(dislikeCountList.toArray(new ObjectId[0]));
        logger.info("Updated dislike count for user discussion: {}", discussion.getId());
      }

      private UserDiscussion findDiscussionById(String discussionId) throws ItemNotFoundException {
        logger.info("Finding user discussion by id: {}", discussionId);

        UserDiscussion discussion = repository.findById(new ObjectId(discussionId))
            .orElseThrow(() -> new ItemNotFoundException("User Discussion not found"));

        logger.info("Found user discussion with id: {}", discussionId);
        return discussion;
      }

      public void deleteDiscussion(String discussionId) throws ItemNotFoundException {
        logger.info("Deleting user discussion: {}", discussionId);
        UserDiscussion discussion = findDiscussionById(discussionId);
        deleteSubDiscussions(new ObjectId(discussionId));
        repository.delete(discussion);
        logger.info("Successfully deleted user discussion: {}", discussionId);
      }

      private void deleteSubDiscussions(ObjectId id) {
        logger.info("Deleting sub-discussions for user discussion: {}", id);
        List<UserDiscussion> discussions = repository.findAllByIdList(id);
        if (discussions != null) {
          repository.deleteAll(discussions);
        }
    }
}