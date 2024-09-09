package com.example.novel_website.mapper.mapperimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.novel_website.dto.ChapterSettingDTO;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.ChapterSetting;

import org.springframework.stereotype.Component;

@Component
public class ChapterSettingMapper implements Mapper<ChapterSettingDTO, ChapterSetting>{
    private static final Logger logger = LoggerFactory.getLogger(ChapterMapper.class);

    @Override
    public ChapterSettingDTO convertToDTO(ChapterSetting chapterSetting) {
        logger.debug("Converting entity to DTO: {}", chapterSetting);

        ChapterSettingDTO chapterSettingDTO = ChapterSettingDTO.builder()
                .userId(chapterSetting.getUserId()) 
                .font(chapterSetting.getFont())
                .fontSize(chapterSetting.getFontSize())
                .lineHeight(chapterSetting.getLineHeight())
                .align(chapterSetting.getAlign())
                .color(chapterSetting.getColor())
                .backgroundColor(chapterSetting.getBackgroundColor())
                .build();

        logger.debug("Converted entity to DTO: {}", chapterSettingDTO);

        return chapterSettingDTO;
    }

    @Override
    public ChapterSetting convertToEntity(ChapterSettingDTO chapterSettingDTO) {
        logger.debug("Converting DTO to entity: {}", chapterSettingDTO);

        ChapterSetting chapterSetting = ChapterSetting.builder()
                .userId(chapterSettingDTO.getUserId()) 
                .font(chapterSettingDTO.getFont())
                .fontSize(chapterSettingDTO.getFontSize())
                .lineHeight(chapterSettingDTO.getLineHeight())
                .align(chapterSettingDTO.getAlign())
                .color(chapterSettingDTO.getColor())
                .backgroundColor(chapterSettingDTO.getBackgroundColor())
                .build();


        logger.debug("Converted DTO to entity: {}", chapterSetting);

        return chapterSetting;
    }
}
