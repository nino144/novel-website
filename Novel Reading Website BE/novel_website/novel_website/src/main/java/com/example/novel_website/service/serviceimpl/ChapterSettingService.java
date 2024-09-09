package com.example.novel_website.service.serviceimpl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.ChapterSettingDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.ChapterSetting;
import com.example.novel_website.service.BaseService;

@Service
public class ChapterSettingService extends BaseService<ChapterSetting, ObjectId, ChapterSettingDTO>{
    @Autowired
    protected Mapper<ChapterSettingDTO, ChapterSetting> mapper;

    public ChapterSettingDTO findById(String userId) throws InterruptedException, ItemNotFoundException{
        logger.debug("Finding setting by userId: {}", userId);
        
        ChapterSetting chapterSetting = findById(new ObjectId(userId));
        ChapterSettingDTO chapterSettingDTO = mapper.convertToDTO(chapterSetting);

        logger.debug("Found setting by that userId: {}", chapterSettingDTO);
        return chapterSettingDTO;
    }

    public ChapterSettingDTO create(String userId) {
        logger.info("Creating Chapter setting: {}");
        ChapterSetting chapterSetting = new ChapterSetting(new ObjectId(userId));
        ChapterSetting savedchapterSetting = repository.save(chapterSetting);
        logger.info("Created Chapter sucessfully: {}");
        return mapper.convertToDTO(savedchapterSetting);
    }

    public ChapterSettingDTO update(String userId, ChapterSettingDTO chapterSettingDTO) throws ItemNotFoundException {
        logger.debug("Updating chapter Setting");
    
        chapterSettingDTO.setUserId(new ObjectId(userId));
        ChapterSetting updatedChapterSetting = handleChapterSettingProperties(chapterSettingDTO);
        updatedChapterSetting = repository.save(updatedChapterSetting);
        logger.debug("Updated  chapter Settingsuccessfully: {}",updatedChapterSetting);
    
        return mapper.convertToDTO(updatedChapterSetting);
    }
    
    private ChapterSetting handleChapterSettingProperties(ChapterSettingDTO chapterSettingDTO) throws ItemNotFoundException {
        ChapterSetting existedChapterSetting = findById(chapterSettingDTO.getUserId());
        ChapterSetting chapterSettingNewInfo = mapper.convertToEntity(chapterSettingDTO);
        return mergeChapterSettingProperties(existedChapterSetting, chapterSettingNewInfo);
    }

    private ChapterSetting mergeChapterSettingProperties(ChapterSetting existingChapterSetting, ChapterSetting newChapterSetting) {
        existingChapterSetting.setFont(newChapterSetting.getFont() != null ? newChapterSetting.getFont() : existingChapterSetting.getFont());
        existingChapterSetting.setFontSize(newChapterSetting.getFontSize() != null ? newChapterSetting.getFontSize() : existingChapterSetting.getFontSize());
        existingChapterSetting.setLineHeight(newChapterSetting.getLineHeight() != null ? newChapterSetting.getLineHeight() : existingChapterSetting.getLineHeight());
        existingChapterSetting.setAlign(newChapterSetting.getAlign() != null ? newChapterSetting.getAlign() : existingChapterSetting.getAlign());
        existingChapterSetting.setColor(newChapterSetting.getColor() != null ? newChapterSetting.getColor() : existingChapterSetting.getColor());
        existingChapterSetting.setBackgroundColor(newChapterSetting.getBackgroundColor() != null ? newChapterSetting.getBackgroundColor() : existingChapterSetting.getBackgroundColor());
        return existingChapterSetting;
    }

    private ChapterSetting findById(ObjectId id) throws ItemNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("chapter setting not found"));
    }
    
}
