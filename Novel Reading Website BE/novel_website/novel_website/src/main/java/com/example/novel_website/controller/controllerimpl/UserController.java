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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel_website.dto.UserDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.model.User;
import com.example.novel_website.service.BaseService;
import com.example.novel_website.service.serviceimpl.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.data.domain.Pageable;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private BaseService<User, ObjectId, UserDTO> userService;
    
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findEnabledUsers(Pageable pageable) {
        try {
            List<UserDTO> usersDTO = ((UserService) userService).findEnabledUsers(pageable);
            logger.info("Retrieving enabled users");
            return new ResponseEntity<>(usersDTO, HttpStatus.OK);
        } 
        catch (InterruptedException e) {
            logger.error("Error when retreiving enabled users", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/all-users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAllUsers(Pageable pageable) {
        try {
            List<UserDTO> usersDTO = ((UserService) userService).findAllUsers(pageable);
            logger.info("Retrieving all users");
            return new ResponseEntity<>(usersDTO, HttpStatus.OK);
        } 
        catch (InterruptedException e) {
            logger.error("Error when retreiving all users", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findById(@PathVariable String userId) {
        try {
            UserDTO userDTO = ((UserService) userService).findById(userId);
            logger.info("Retrieving user");
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when retreiving user", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // @PostMapping
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<?> create(@RequestBody UserDTO userDTO) {
    //     ((UserService) userService).create(userDTO);
    //     logger.info("creating user");
    //     return new ResponseEntity<>(HttpStatus.OK);
    // }

    @PutMapping("/disable/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> disableUser(@PathVariable String id) {
        try {
            ((UserService) userService).disableUser(id);
            logger.info("Disabling novel");
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when disabling user", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/enable/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> enableUser(@PathVariable String id) {
        try {
            ((UserService) userService).enableUser(id);
            logger.info("Enabling user");
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when enabling user", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        try {
            ((UserService) userService).update(userDTO);
            logger.info("Updating user: {}", userDTO);
            return new ResponseEntity<>(HttpStatus.OK); 
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when updating user", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update-role/{userId}/{role}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateRole(@PathVariable String userId, @PathVariable String role) {
        try {
            ((UserService) userService).updateRole(userId, role);
            logger.info("Updating user role: {}", userId, role);
            return new ResponseEntity<>(HttpStatus.OK); 
        } 
        catch (ItemNotFoundException e) {
            logger.error("Error when updating user role", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
