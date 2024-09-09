package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.NovelDTO;
import com.example.novel_website.dto.NovelPopularityDTO;
import com.example.novel_website.dto.NovelTraitsDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Novel;
import com.example.novel_website.model.NovelPopularity;
import com.example.novel_website.model.NovelTraits;

@Component
public class NovelMapper implements Mapper<NovelDTO, Novel> {
    private static final Logger logger = LoggerFactory.getLogger(NovelMapper.class);

    @Autowired
    NovelPopularityMapper novelPopularityMapper;

    @Autowired
    NovelTraitsMapper novelTraitsMapper;

    @Override
    public NovelDTO convertToDTO(Novel novel) {
        logger.debug("Converting entity to DTO: {}", novel);

        NovelPopularityDTO popularityDTO = novelPopularityMapper.convertToDTO(novel.getNovelPopularity());
        NovelTraitsDTO traitsDTO = novelTraitsMapper.convertToDTO(novel.getNovelTraits());

        NovelDTO novelDTO = NovelDTO.builder()
                .name(novel.getName())
                .imageURL(novel.getImageURL())
                .description(novel.getDescription())
                .author(novel.getAuthor())
                .category(novel.getCategory())
                .chapter(novel.getChapter())
                .active(novel.isActive())
                .novelPopularity(popularityDTO)
                .novelTraits(traitsDTO)
                .build();

        logger.debug("Converted entity to DTO: {}", novelDTO);

        return novelDTO;
    }

    @Override
    public Novel convertToEntity(NovelDTO novelDTO) {
        logger.debug("Converting DTO to entity: {}", novelDTO);

        NovelPopularity popularity = novelPopularityMapper.convertToEntity(novelDTO.getNovelPopularity());
        NovelTraits traits = novelTraitsMapper.convertToEntity(novelDTO.getNovelTraits());

        Novel novel = Novel.builder()
            .description(novelDTO.getDescription())
            .author(novelDTO.getAuthor())
            .category(novelDTO.getCategory())
            .chapter(novelDTO.getChapter())
            .active(novelDTO.isActive())
            .novelPopularity(popularity)
            .novelTraits(traits)
            .build();

        logger.debug("Converted DTO to entity: {}", novel);

        return novel;
    }
}
