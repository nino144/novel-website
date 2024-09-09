package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.NovelPopularityDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.NovelPopularity;

@Component
public class NovelPopularityMapper implements Mapper<NovelPopularityDTO, NovelPopularity>{

    private static final Logger logger = LoggerFactory.getLogger(NovelPopularityMapper.class);

    @Override
    public NovelPopularityDTO convertToDTO(NovelPopularity novelPopularity) {
        logger.debug("Converting entity to DTO: {}", novelPopularity);

        NovelPopularityDTO novelPopularityDTO = NovelPopularityDTO.builder()
                .views(novelPopularity.getViews())
                .nominates(novelPopularity.getNominates())
                .stores(novelPopularity.getStores())
                .rating(novelPopularity.getRating())
                .build();

        logger.debug("Converted entity to DTO: {}", novelPopularityDTO);
        return novelPopularityDTO;
    }

    @Override
    public NovelPopularity convertToEntity(NovelPopularityDTO novelPopularityDTO) {
        logger.debug("Converting DTO to entity: {}", novelPopularityDTO);

        NovelPopularity novelPopularity = NovelPopularity.builder()
            .views(novelPopularityDTO.getViews())
            .nominates(novelPopularityDTO.getNominates())
            .stores(novelPopularityDTO.getStores())
            .rating(novelPopularityDTO.getRating())
            .build();

        logger.debug("Converted DTO to entity: {}", novelPopularity);
        return novelPopularity;
    }
}

