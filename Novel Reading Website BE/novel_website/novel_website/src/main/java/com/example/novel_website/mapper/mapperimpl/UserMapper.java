package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.UserDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.User;

@Component
public class UserMapper implements Mapper<UserDTO, User>{
    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    @Override
    public UserDTO convertToDTO(User user) {
        logger.debug("Converting entity to DTO: {}", user);

        UserDTO userDTO = UserDTO.builder()
                .id(user.getId()) // Convert ObjectId to String
                .name(user.getName())
                .imageURL(user.getImageURL())
                .roles(user.getRoles())
                .email(user.getEmail())
                .password(user.getPassword())
                .dateOfBirth(user.getDateOfBirth())
                .gender(user.getGender())
                .joinDate(user.getJoinDate())
                .active(user.isActive())
                .build();

        logger.debug("Converted entity to DTO: {}", userDTO);
        return userDTO;
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        logger.debug("Converting DTO to entity: {}", userDTO);
        
        User user = User.builder()
                .id(userDTO.getId()) // Convert ObjectId to String
                .name(userDTO.getName())
                .imageURL(userDTO.getImageURL())
                .roles(userDTO.getRoles())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .dateOfBirth(userDTO.getDateOfBirth())
                .gender(userDTO.getGender())
                .joinDate(userDTO.getJoinDate())
                .active(userDTO.isActive())
                .build();

        logger.debug("Converted DTO to entity: {}", user);
        return user;
    }
}
