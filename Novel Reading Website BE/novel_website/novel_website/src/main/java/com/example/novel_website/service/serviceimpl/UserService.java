package com.example.novel_website.service.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.UserDTO;
import com.example.novel_website.enums.ERole;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Role;
import com.example.novel_website.model.User;
import com.example.novel_website.repository.RoleRepository;
import com.example.novel_website.repository.UserRepository;
import com.example.novel_website.service.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class UserService extends BaseService<User, ObjectId, UserDTO>{
    @Autowired
    protected Mapper<UserDTO, User> mapper;

    @Autowired
    RoleRepository roleRepository;

    public List<UserDTO> findEnabledUsers(Pageable pageable) throws InterruptedException {
        logger.debug("Finding enabled users");

        Page<User> usersPage = ((UserRepository) repository).findEnabledUsers(pageable);
        Page<UserDTO> usersDTOPage = usersPage.map(mapper::convertToDTO);
        List<UserDTO> usersDTOList = usersDTOPage.getContent();

        logger.debug("Found enabled users: {}", usersDTOList);
        return usersDTOList;
    }

    public List<UserDTO> findAllUsers(Pageable pageable) throws InterruptedException {
        logger.debug("Finding all users");

        Page<User> usersPage = ((UserRepository) repository).findAllUsers(pageable);
        Page<UserDTO> usersDTOPage = usersPage.map(mapper::convertToDTO);
        List<UserDTO> usersDTOList = usersDTOPage.getContent();

        logger.debug("Found all users: {}", usersDTOList);
        return usersDTOList;
    }

    // private List<UserDTO> convertToDTOs(List<User> users) {
    //     return users.stream()
    //             .map(mapper::convertToDTO)
    //             .collect(Collectors.toList());
    // }

    public void enableUser(String id) throws ItemNotFoundException  {
        toggleUser(id, true);
    }

    public void disableUser(String id) throws ItemNotFoundException  {
        toggleUser(id, false);
    }

    public UserDTO findById(String userId) throws ItemNotFoundException {
        return mapper.convertToDTO(findById(new ObjectId(userId)));
    }

    private User findById(ObjectId id) throws ItemNotFoundException {
        return ((UserRepository) repository).findById(id)
                .orElseThrow(() -> new ItemNotFoundException("User not found"));
    } 

    public UserDTO findByEmailAndIsActive(String email) throws ItemNotFoundException {
        User user = ((UserRepository) repository).findByEmailAndIsActive(email)
                .orElseThrow(() -> new ItemNotFoundException("User not found"));

        return mapper.convertToDTO(user);
    }

    public UserDTO findByName(String name) throws ItemNotFoundException {
        User user = ((UserRepository) repository).findByName(name)
                .orElseThrow(() -> new ItemNotFoundException("User not found"));

        return mapper.convertToDTO(user);
    }

    private void toggleUser(String id, boolean state) throws ItemNotFoundException{
        ObjectId objectId = new ObjectId(id);
        User user = findById(objectId);
        user.setActive(!user.isActive());
        repository.save(user);
    }

    public UserDTO create(UserDTO userDTO) {
        logger.info("Creating user: {}");
        User user = mapper.convertToEntity(userDTO);
        User savedUser = repository.save(user);
        logger.info("Created novel sucessfully: {}");
        return mapper.convertToDTO(savedUser);
    }

    public UserDTO update(UserDTO userDTO) throws ItemNotFoundException {
        logger.debug("Updating user");
    
        User updatedUser = handleUserProperties(userDTO);
        updatedUser = repository.save(updatedUser);
        logger.debug("Updated user successfully: {}", updatedUser);
    
        return mapper.convertToDTO(updatedUser);
    }
    
    private User handleUserProperties(UserDTO userDTO) throws ItemNotFoundException {
        User existedUser = findById(userDTO.getId());
        User userNewInfo = mapper.convertToEntity(userDTO);
        return mergeUserProperties(existedUser, userNewInfo);
    }
    
    private User mergeUserProperties(User existingUser, User userNewInfo) {
        existingUser.setName(userNewInfo.getName() != null ? userNewInfo.getName() : existingUser.getName());
        existingUser.setImageURL(userNewInfo.getImageURL() != null ? userNewInfo.getImageURL() : existingUser.getImageURL());
        existingUser.setEmail(userNewInfo.getEmail() != null ? userNewInfo.getEmail() : existingUser.getEmail());
        existingUser.setPassword(userNewInfo.getPassword() != null ? userNewInfo.getPassword() : existingUser.getPassword());
        existingUser.setDateOfBirth(userNewInfo.getDateOfBirth() != null ? userNewInfo.getDateOfBirth() : existingUser.getDateOfBirth());
        existingUser.setGender(userNewInfo.getGender() != null ? userNewInfo.getGender() : existingUser.getGender());
    
        return existingUser;
    }

    public void updateRole(String userId, String role) throws ItemNotFoundException{
        User user = findById(new ObjectId(userId));
        Set<Role> roles = new HashSet<>();

        switch (role) {
            case "user":
                Role userRole = roleRepository.findByName(ERole.ROLE_USER);
                roles.add(userRole);
                break;
            case "admin":
                Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
                roles.add(adminRole);
                break;
        }

        user.setRoles(roles);
        repository.save(user);
    }
}
