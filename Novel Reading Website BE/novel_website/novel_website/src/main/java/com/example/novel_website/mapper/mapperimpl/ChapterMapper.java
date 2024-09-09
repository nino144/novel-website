package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.novel_website.dto.ChapterDTO;
import com.example.novel_website.dto.ChapterOverviewDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Chapter;

@Component
public class ChapterMapper implements Mapper<ChapterDTO, Chapter> {
    private static final Logger logger = LoggerFactory.getLogger(ChapterMapper.class);

    @Override
    public ChapterDTO convertToDTO(Chapter chapter) {
        logger.debug("Converting entity to DTO: {}", chapter);

        ChapterDTO chapterDTO = ChapterDTO.builder()
                .id(chapter.getId()) 
                .novelName(chapter.getNovelName())
                .chapterNumber(chapter.getChapterNumber())
                .chapterTitle(chapter.getChapterTitle())
                .content(chapter.getContent())
                .publishDate(chapter.getPublishDate())
                .active(chapter.isActive())
                .build();

        logger.debug("Converted entity to DTO: {}", chapterDTO);

        return chapterDTO;
    }

    @Override
    public Chapter convertToEntity(ChapterDTO chapterDTO) {
        logger.debug("Converting DTO to entity: {}", chapterDTO);

        Chapter chapter = Chapter.builder()
            .id(chapterDTO.getId()) 
            .novelName(chapterDTO.getNovelName())
            .chapterNumber(chapterDTO.getChapterNumber())
            .chapterTitle(chapterDTO.getChapterTitle())
            .content(chapterDTO.getContent())
            .publishDate(chapterDTO.getPublishDate())
            .active(chapterDTO.isActive())
            .build();

        logger.debug("Converted DTO to entity: {}", chapter);

        return chapter;
    }

    public ChapterOverviewDTO convertChapterToChapterOverviewDTO(Chapter chapter) {
        logger.debug("Converting entity to specifig DTO: {}", chapter);

        ChapterOverviewDTO chapterOverviewDTO = ChapterOverviewDTO.builder()
                .id(chapter.getId()) 
                .novelName(chapter.getNovelName())
                .chapterNumber(chapter.getChapterNumber())
                .chapterTitle(chapter.getChapterTitle())
                //.content(chapter.getContent())
                .publishDate(chapter.getPublishDate())
                .active(chapter.isActive())
                .build();

        logger.debug("Converted entity to specifig DTO: {}", chapterOverviewDTO);

        return chapterOverviewDTO;
    }
}

