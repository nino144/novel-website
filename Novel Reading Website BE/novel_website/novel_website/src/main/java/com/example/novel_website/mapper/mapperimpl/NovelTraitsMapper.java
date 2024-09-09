package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.NovelTraitsDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.NovelTraits;

@Component
public class NovelTraitsMapper implements Mapper<NovelTraitsDTO, NovelTraits>{
    private static final Logger logger = LoggerFactory.getLogger(NovelTraitsMapper.class);

    @Override
    public NovelTraitsDTO convertToDTO(NovelTraits novelTraits) {
        logger.debug("Converting entity to DTO: {}", novelTraits);

        NovelTraitsDTO novelTraitsDTO = NovelTraitsDTO.builder()
                .wordContext(novelTraits.getWordContext())
                .vision(novelTraits.getVision())
                .status(novelTraits.getStatus())
                .characterTrait(novelTraits.getCharacterTrait())
                .build();

        logger.debug("Converted entity to DTO: {}", novelTraitsDTO);
        return novelTraitsDTO;
    }

    @Override
    public NovelTraits convertToEntity(NovelTraitsDTO novelTraitsDTO) {
        logger.debug("Converting DTO to entity: {}", novelTraitsDTO);

        NovelTraits novelTraits = NovelTraits.builder()
                .wordContext(novelTraitsDTO.getWordContext())
                .vision(novelTraitsDTO.getVision())
                .status(novelTraitsDTO.getStatus())
                .characterTrait(novelTraitsDTO.getCharacterTrait())
                .build();

        logger.debug("Converted DTO to entity: {}", novelTraits);
        return novelTraits;

    }

}
