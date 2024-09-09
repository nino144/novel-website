package com.example.novel_website.controller.controllerimpl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.dto.NovelDTO;
import com.example.novel_website.dto.NovelInteractionDTO;
import com.example.novel_website.enums.Interaction;
import com.example.novel_website.model.Novel;
import com.example.novel_website.model.NovelInteraction;
import com.example.novel_website.service.BaseService;
import com.example.novel_website.service.serviceimpl.NovelInteractionService;
import com.example.novel_website.service.serviceimpl.NovelService;

import org.bson.types.ObjectId;
import org.slf4j.Logger;

@CrossOrigin
@RestController
@RequestMapping("/api/novels")
public class NovelController{
    private static final Logger logger = LoggerFactory.getLogger(NovelController.class);

    @Autowired
    private BaseService<Novel, String, NovelDTO> novelService;

    @Autowired
    private BaseService<NovelInteraction, ObjectId, NovelInteractionDTO> novelInteractionService;

    @GetMapping 
    public ResponseEntity<?> findEnabledNovels(Pageable pageable) {
        try {
            List<NovelDTO> novelsDTO = ((NovelService) novelService).findEnabledNovels(pageable);
            logger.info("Retrieving enabled novels");
            return new ResponseEntity<>(novelsDTO, HttpStatus.OK);
        } 
        catch (InterruptedException e) {
            logger.error("Error when retreiving enabled novels", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/search") // Endpoint for searching novels by name
    public ResponseEntity<?> findByName(@RequestParam("name") String name) {
        try{
            NovelDTO novelsDTO = ((NovelService) novelService).findByName(name);
            logger.info("Retrieving novel by name");
            return new ResponseEntity<>(novelsDTO, HttpStatus.OK);
        }
        catch (InterruptedException e) {
            logger.error("Error when retreiving novel by name", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> queryNovelsByTypeAndDatetime(
                @RequestParam Interaction interactionType, 
                @RequestParam String datetime,
                Pageable pageable) {
        try{
            List<NovelDTO> novelsDTO = ((NovelService) novelService)
                                            .queryNovelsByTypeAndDatetime(interactionType, datetime, pageable);

            logger.info("Querying novels by type and datetime");
            return new ResponseEntity<>(novelsDTO, HttpStatus.OK);
        }
        catch (InterruptedException e) {
            logger.error("Error when querying novels", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/counter")
    public ResponseEntity<?> processNewRecord(
                @RequestParam String novelName,
                @RequestParam String interactionType, 
                @RequestParam String value
                ) {
        ((NovelInteractionService) novelInteractionService).processNewRecord(novelName, Interaction.valueOf(interactionType), value);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody NovelDTO novelDTO) {
        ((NovelService) novelService).create(novelDTO);
        logger.info("creating novel");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/disable/{name}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> disableNovel(@PathVariable String name) {
        ((NovelService) novelService).disableNovel(name);
        logger.info("Disabling novel");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/enable/{name}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> enableNovel(@PathVariable String name) {
        ((NovelService) novelService).enableNovel(name);
        logger.info("Enabling novel");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
