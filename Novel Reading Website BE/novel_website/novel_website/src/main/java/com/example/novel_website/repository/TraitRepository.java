package com.example.novel_website.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.novel_website.model.Trait;
import com.example.novel_website.repository.queries.TraitQueries;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface TraitRepository extends MongoRepository<Trait, ObjectId> {
  @Query(TraitQueries.FIND_BY_NAME)
  Page<Trait> findByName(@Param("name") String name, Pageable pageable); // Existing method

  @Query(TraitQueries.FIND_BY_NAME)
  List<Trait> findAllByName(@Param("name") String name); // Existing method

  @Query(TraitQueries.FIND_ENABLED_TRAITS)
  Page<Trait> findEnabledTraits(Pageable pageable);
}