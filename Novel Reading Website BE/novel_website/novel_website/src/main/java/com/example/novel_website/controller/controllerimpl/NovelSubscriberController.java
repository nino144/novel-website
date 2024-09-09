package com.example.novel_website.controller.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.service.serviceimpl.NovelSubscriberService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/api/subscribers")
public class NovelSubscriberController {
    private static final Logger logger = LoggerFactory.getLogger(NovelSubscriberController.class);

    @Autowired
    private NovelSubscriberService novelSubscriberService;

    @PostMapping("/{userId}/{novelName}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> subscribe(@PathVariable String userId, @PathVariable String novelName) {
        try {
            novelSubscriberService.subscribe(userId, novelName);
            logger.info("User {} subscribed to novel {}", userId, novelName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error when subscribing user to novel", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}/{novelName}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> unsubscribe(@PathVariable String userId, @PathVariable String novelName) {
        try {
            novelSubscriberService.unsubscribe(userId, novelName);
            logger.info("User {} unsubscribed from novel {}", userId, novelName);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            logger.error("Error when unsubscribing user from novel", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
