package com.example.novel_website.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T, ID, D> {
    protected static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected MongoRepository<T, ID> repository; // Use MongoRepository

}