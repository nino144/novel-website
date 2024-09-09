package com.example.novel_website.controller.controllerimpl;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.dto.ChapterSettingDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.model.ChapterSetting;
import com.example.novel_website.service.BaseService;
import com.example.novel_website.service.serviceimpl.ChapterSettingService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/api/chapterSettings")
public class ChapterSettingController {

    private static final Logger logger = LoggerFactory.getLogger(ChapterSettingController.class);

    @Autowired
    private BaseService<ChapterSetting, ObjectId, ChapterSettingDTO> chapterSettingService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> findById(@PathVariable String userId) throws ItemNotFoundException {
        try {
            ChapterSettingDTO chapterSettingDTO = ((ChapterSettingService) chapterSettingService).findById(userId);
            logger.info("finding chapter setting");
            return new ResponseEntity<>(chapterSettingDTO, HttpStatus.OK);
        } 
        catch (InterruptedException e) {
            logger.error("Error when finding chapter setting", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> create(@PathVariable String userId) {
        ((ChapterSettingService) chapterSettingService).create(userId);
        logger.info("creating chapter setting");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable String userId, @RequestBody ChapterSettingDTO chapterSettingDTO) throws ItemNotFoundException {
        try {
            ((ChapterSettingService) chapterSettingService).update(userId, chapterSettingDTO);
            logger.info("Updating chapter setting: {}", chapterSettingDTO);
            return new ResponseEntity<>(HttpStatus.OK);  
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when updating chapter setting");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}