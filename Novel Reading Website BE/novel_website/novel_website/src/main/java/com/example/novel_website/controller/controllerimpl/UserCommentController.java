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

import com.example.novel_website.dto.UserCommentDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.service.serviceimpl.UserCommentService;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.data.domain.Pageable;

@CrossOrigin
@RestController
@RequestMapping("/api/comments")
public class UserCommentController{
    private static final Logger logger = LoggerFactory.getLogger(UserCommentController.class);

    @Autowired
    private UserCommentService userCommentService;
    
    @GetMapping("/novel/{novelName}")
    public ResponseEntity<?> getCommentsByNovelName(@PathVariable String novelName, Pageable pageable) {
        List<UserCommentDTO> comments;
        try {
            comments = userCommentService.findByNovelName(novelName, pageable);
            logger.info("find comments by novel name");
            return ResponseEntity.ok(comments);
        } catch (InterruptedException e) {
            logger.error("Error when find comments by novel name", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } 
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createComment(@RequestBody UserCommentDTO userCommentDTO) throws ItemNotFoundException {
        logger.info("Creating comment: {}", userCommentDTO);
        UserCommentDTO savedCommentDTO = userCommentService.create(userCommentDTO);
        logger.info("Comment created successfully: {}", savedCommentDTO);
        return ResponseEntity.ok(savedCommentDTO);
    }

    @PutMapping("/like/{commentId}/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> likeComment(@PathVariable String commentId, @PathVariable String userId) throws ItemNotFoundException {
        logger.info("Liking comment: {}, userId: {}", commentId, userId);
        userCommentService.likeComment(userId, commentId);
        logger.info("Comment liked successfully: {}", commentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/dislike/{commentId}/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> dislikeComment(@PathVariable String commentId, @PathVariable String userId) throws ItemNotFoundException {
        logger.info("Disliking comment: {}, userId: {}", commentId, userId);
        userCommentService.dislikeComment(userId, commentId);
        logger.info("Comment disliked successfully: {}", commentId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteComment(@PathVariable String commentId) throws ItemNotFoundException {
        logger.info("Deleting comment: {}", commentId);
        userCommentService.deleteComment(commentId);
        logger.info("Comment deleted successfully: {}", commentId);
        return ResponseEntity.ok().build();
    }
}
