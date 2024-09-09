package com.example.novel_website.controller.controllerimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.dto.UserDiscussionDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.service.serviceimpl.UserDiscussionService;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.data.domain.Pageable;


@CrossOrigin
@RestController
@RequestMapping("/api/discussions")
public class UserDiscussionController{

    private static final Logger logger = LoggerFactory.getLogger(UserDiscussionController.class);

    @Autowired
    private UserDiscussionService userDiscussionService;

    @GetMapping("/novel/{novelName}")
    public ResponseEntity<?> getDiscussionsByNovelName(@PathVariable String novelName, Pageable pageable) {
        try {
            List<UserDiscussionDTO> discussions = userDiscussionService.findByNovelName(novelName, pageable);
            logger.info("Finding discussions by novel name");
            return ResponseEntity.ok(discussions);
        }catch (InterruptedException e) {
            logger.error("Error when Finding discussions by novel name", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createDiscussion(@RequestBody UserDiscussionDTO userDiscussionDTO) throws ItemNotFoundException {
        logger.info("Creating discussion: {}", userDiscussionDTO);
        UserDiscussionDTO savedDiscussionDTO = userDiscussionService.create(userDiscussionDTO);
        logger.info("Discussion created successfully: {}", savedDiscussionDTO);
        return ResponseEntity.ok(savedDiscussionDTO);
    }

    @PutMapping("/like/{discussionId}/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> likeDiscussion(@PathVariable String discussionId, @PathVariable String userId) throws ItemNotFoundException {
        logger.info("Liking discussion: {}, userId: {}", discussionId, userId);
        userDiscussionService.likeDiscussion(userId, discussionId);
        logger.info("Discussion liked successfully: {}", discussionId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/dislike/{discussionId}/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> dislikeDiscussion(@PathVariable String discussionId, @PathVariable String userId) throws ItemNotFoundException {
        logger.info("Disliking discussion: {}, userId: {}", discussionId, userId);
        userDiscussionService.dislikeDiscussion(userId, discussionId);
        logger.info("Discussion disliked successfully: {}", discussionId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{discussionId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteDiscussion(@PathVariable String discussionId) throws ItemNotFoundException {
        logger.info("Deleting discussion: {}", discussionId);
        userDiscussionService.deleteDiscussion(discussionId);
        logger.info("Discussion deleted successfully: {}", discussionId);
        return ResponseEntity.ok().build();
    }
}