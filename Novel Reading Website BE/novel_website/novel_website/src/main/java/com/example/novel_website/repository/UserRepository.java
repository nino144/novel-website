package com.example.novel_website.repository;

import org.bson.types.ObjectId;

import com.example.novel_website.model.User;
import com.example.novel_website.repository.queries.UserQueries;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query(UserQueries.FIND_ENABLED_USERS)
    Page<User> findEnabledUsers(Pageable pageable); 

    @Query(UserQueries.FIND_ALL_USERS)
    Page<User> findAllUsers(Pageable pageable);

    @Query(UserQueries.FIND_BY_EMAIL_AND_IS_ACTIVE)
    Optional<User> findByEmailAndIsActive(String email);

    @Query(UserQueries.FIND_BY_NAME)
    Optional<User> findByName(String name);

    boolean existsByName(String userName);

    boolean existsByEmail(String email);

}
