package com.example.novel_website.controller.controllerimpl;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.dto.ReadProgressDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.exception.ReadProgressExistException;
import com.example.novel_website.model.ReadProgress;
import com.example.novel_website.service.BaseService;
import com.example.novel_website.service.serviceimpl.ReadProgressService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/api/read-progress")
public class ReadProgressController {
    private static final Logger logger = LoggerFactory.getLogger(ReadProgressController.class);

    @Autowired
    private BaseService<ReadProgress, ObjectId, ReadProgressDTO> readProgressService;

    @GetMapping("/currently-reading/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> findByUserIdIsCurrentlyReadingTrue(@PathVariable String userId, Pageable pageable) {
        try {
            List<ReadProgressDTO> readProgressDTOs = ((ReadProgressService) readProgressService)
                                                        .findByUserIdIsCurrentlyReadingTrue(userId, pageable);
            logger.info("Finding currently reading novels");
            return new ResponseEntity<>(readProgressDTOs, HttpStatus.OK);
        } catch (InterruptedException e) {
            logger.error("Error when finding currently reading novels", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> findByUserId(@PathVariable String userId, Pageable pageable) {
        try {
            List<ReadProgressDTO> readProgressDTOs = ((ReadProgressService) readProgressService)
                                                        .findByUserId(userId, pageable);
            logger.info("Finding novels");
            return new ResponseEntity<>(readProgressDTOs, HttpStatus.OK);
        } catch (InterruptedException e) {
            logger.error("Error when finding novels", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/marked/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> findByUserIdAndIsMarkedTrue(@PathVariable String userId, Pageable pageable) {
        try {
            List<ReadProgressDTO> readProgressDTOs = ((ReadProgressService) readProgressService)
                                                        .findByUserIdAndIsMarkedTrue(userId, pageable);
            logger.info("Finding marked novels");
            return new ResponseEntity<>(readProgressDTOs, HttpStatus.OK);
        } catch (InterruptedException e) {
            logger.error("Error when finding marked novels", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody ReadProgressDTO readProgressDTO) {
        try {
            ReadProgressDTO createdReadProgressDTO = ((ReadProgressService) readProgressService).create(readProgressDTO);
            logger.info("Creating read progress");
            return new ResponseEntity<>(createdReadProgressDTO, HttpStatus.OK);
        } catch (ReadProgressExistException e) {
            logger.error("Error when creating read progress", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            ((ReadProgressService) readProgressService).delete(id);
            logger.info("Deleting read progress");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            logger.error("Error when deleting read progress", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
