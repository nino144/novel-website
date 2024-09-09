package com.example.novel_website.controller.controllerimpl;

import java.util.List;

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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.novel_website.dto.ChapterDTO;
import com.example.novel_website.dto.ChapterOverviewDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.model.Chapter;
import com.example.novel_website.service.BaseService;
import com.example.novel_website.service.serviceimpl.ChapterService;

@CrossOrigin
@RestController
@RequestMapping("/api/chapters") 
public class ChapterController {
    private static final Logger logger = LoggerFactory.getLogger(ChapterController.class);

    @Autowired
    private BaseService<Chapter, ObjectId, ChapterDTO> chapterService;

    @GetMapping("/{novelName}/{chapterNumber}") 
    public ResponseEntity<?> findByNovelNameAndChapterNumber(@PathVariable String novelName, @PathVariable Integer chapterNumber){
        try {
            ChapterDTO chapterDTO = ((ChapterService) chapterService)
                        .findByNovelNameAndChapterNumber(novelName, chapterNumber);
            logger.info("finding chapter");
            return new ResponseEntity<>(chapterDTO, HttpStatus.OK);
        } 
        catch (InterruptedException | ItemNotFoundException e) {
            logger.error("Error when finding chapter", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{novelName}") 
    public ResponseEntity<?> findOverviewsByNovelName(@PathVariable String novelName){
        try {
            List<ChapterOverviewDTO> chapterOverviewDTOs = ((ChapterService) chapterService)
                        .findOverviewsByNovelName(novelName);
            logger.info("finding chapter overview");
            return new ResponseEntity<>(chapterOverviewDTOs, HttpStatus.OK);
        } 
        catch (InterruptedException e) {
            logger.error("Error when finding chapter", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody ChapterDTO chapterDTO) {
        ((ChapterService) chapterService).create(chapterDTO);
        logger.info("creating chapter");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody ChapterDTO chapterDTO) {
        try {
            ((ChapterService) chapterService).update(chapterDTO);
            logger.info("Updating chapter: {}", chapterDTO);
            return new ResponseEntity<>(HttpStatus.OK);  
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when updating chapter");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/enable/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> enableChapter(@PathVariable String id)  {
        try {
            ((ChapterService) chapterService).enableChapter(id);
            logger.info("Enabling chapter");
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when enabling chapter", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/disable/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> disableChapter(@PathVariable String id){
        try {
            ((ChapterService) chapterService).disableChapter(id);
            logger.info("disabling chapter");
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when disabling chapter", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}