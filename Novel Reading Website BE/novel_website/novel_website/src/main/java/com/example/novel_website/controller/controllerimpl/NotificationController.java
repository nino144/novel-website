package com.example.novel_website.controller.controllerimpl;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.dto.NotificationDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.service.serviceimpl.NotificationService;

@CrossOrigin
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> findByUserId(@PathVariable String userId) {
        try {
            List<NotificationDTO> notificationsDTO = notificationService.findByUserId(new ObjectId(userId));
            logger.info("Retrieving notifications");
            return new ResponseEntity<>(notificationsDTO, HttpStatus.OK);
        } catch (InterruptedException e) {
            logger.error("Error when retrieving notifications", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{notificationId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable String notificationId) {
        try {
            NotificationDTO notificationDTO = notificationService.update(notificationId);
            logger.info("Updating notification: {}", notificationDTO);
            return new ResponseEntity<>(notificationDTO, HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            logger.error("Error when updating notification");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
