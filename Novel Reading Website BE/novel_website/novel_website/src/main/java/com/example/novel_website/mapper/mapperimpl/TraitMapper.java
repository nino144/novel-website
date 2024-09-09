package com.example.novel_website.mapper.mapperimpl;

import org.springframework.stereotype.Component;

import com.example.novel_website.dto.TraitDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Trait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TraitMapper implements Mapper<TraitDTO, Trait> {
    private static final Logger logger = LoggerFactory.getLogger(TraitMapper.class);

    @Override
    public TraitDTO convertToDTO(Trait trait) {
        logger.debug("Converting entity to DTO: {}", trait);

        TraitDTO traitDTO = TraitDTO.builder()
                .id(trait.getId()) // Convert ObjectId to String
                .name(trait.getName())
                .description(trait.getDescription())
                .value(trait.getValue())
                .active(trait.isActive())
                .build();

        logger.debug("Converted entity to DTO: {}", traitDTO);
        return traitDTO;
    }

    @Override
    public Trait convertToEntity(TraitDTO traitDTO) {
        logger.debug("Converting DTO to entity: {}", traitDTO);
        
        Trait trait = Trait.builder()
                .id(traitDTO.getId())
                .name(traitDTO.getName())
                .description(traitDTO.getDescription())
                .value(traitDTO.getValue())
                .active(traitDTO.isActive())
                .build();

        logger.debug("Converted DTO to entity: {}", trait);
        return trait;
    }
}
