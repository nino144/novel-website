package com.example.novel_website.controller.controllerimpl;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.dto.TraitDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.model.Trait;
import com.example.novel_website.service.BaseService;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.novel_website.service.serviceimpl.TraitService;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.data.domain.Pageable;

@CrossOrigin
@RestController
@RequestMapping("/api/traits")
public class TraitController{
    private static final Logger logger = LoggerFactory.getLogger(TraitController.class);

    @Autowired
    private BaseService<Trait, ObjectId, TraitDTO> traitService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        try {
            TraitDTO traitDTO = ((TraitService) traitService).findById(new ObjectId(id));
            logger.info("Retrieving trait");
            return new ResponseEntity<>(traitDTO, HttpStatus.OK);
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when retreiving trait", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping 
    public ResponseEntity<?> findEnabledTraits(Pageable pageable) {
        try {
            List<TraitDTO> traitsDTO = ((TraitService) traitService).findEnabledTraits(pageable);
            logger.info("Retrieving enabled traits");
            return new ResponseEntity<>(traitsDTO, HttpStatus.OK);
        } 
        catch (InterruptedException e) {
            logger.error("Error when retreiving enabled traits", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String name, Pageable pageable) {
        try {
            List<TraitDTO> traitsDTO = ((TraitService) traitService).findByName(name, pageable);
            logger.info("Retrieving traits with that name");
            return new ResponseEntity<>(traitsDTO, HttpStatus.OK);
        } 
        catch (InterruptedException e) {
            logger.error("Error when retreiving traits", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody TraitDTO traitDTO) {
        ((TraitService) traitService).create(traitDTO); 
        logger.info("Creating trait");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody TraitDTO traitDTO) {
        try {
            ((TraitService) traitService).update(traitDTO);
            logger.info("Updating trait: {}", traitDTO);
            return new ResponseEntity<>(HttpStatus.OK);  
        } 
        catch (ItemNotFoundException | InterruptedException e) {
            logger.error("Error when updating trait");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/disable/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> disableTrait(@PathVariable String id) {
        try {
            ((TraitService) traitService).disableTrait(new ObjectId(id));
            logger.info("Disabling trait");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            logger.error("Error when disabling trait", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/enable/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> enableTrait(@PathVariable String id) {
        try {
            ((TraitService) traitService).enableTrait(new ObjectId(id));
            logger.info("Enabling trait");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            logger.error("Error when enabling trait", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
