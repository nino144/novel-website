package com.example.novel_website.mapper.mapperimpl;

import com.example.novel_website.dto.ReadProgressDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.ReadProgress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReadProgressMapper implements Mapper<ReadProgressDTO, ReadProgress> {
    private static final Logger logger = LoggerFactory.getLogger(ReadProgressMapper.class);

    public ReadProgressDTO convertToDTO(ReadProgress readProgress) {
        logger.debug("Converting entity to DTO: {}", readProgress);

        ReadProgressDTO readProgressDTO = ReadProgressDTO.builder()
                .id(readProgress.getId())
                .novelName(readProgress.getNovelName())
                .userId(readProgress.getUserId())
                .imageURL(readProgress.getImageURL())
                .chapterTitle(readProgress.getChapterTitle())
                .chapter(readProgress.getChapter())
                .time(readProgress.getTime())
                .marked(readProgress.isMarked())
                .currentlyReading(readProgress.isCurrentlyReading())
                .build();

        logger.debug("Converted entity to DTO: {}", readProgressDTO);
        return readProgressDTO;
    }

    public ReadProgress convertToEntity(ReadProgressDTO readProgressDTO) {
        logger.debug("Converting DTO to entity: {}", readProgressDTO);

        ReadProgress readProgress = ReadProgress.builder()
                .id(readProgressDTO.getId())
                .novelName(readProgressDTO.getNovelName())
                .userId(readProgressDTO.getUserId())
                .imageURL(readProgressDTO.getImageURL())
                .chapterTitle(readProgressDTO.getChapterTitle())
                .chapter(readProgressDTO.getChapter())
                .time(readProgressDTO.getTime())
                .marked(readProgressDTO.isMarked())
                .currentlyReading(readProgressDTO.isCurrentlyReading())
                .build();

        logger.debug("Converted DTO to entity: {}", readProgress);
        return readProgress;
    }

}
