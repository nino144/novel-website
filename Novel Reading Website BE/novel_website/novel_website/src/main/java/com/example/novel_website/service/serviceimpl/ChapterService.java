package com.example.novel_website.service.serviceimpl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.ChapterDTO;
import com.example.novel_website.dto.ChapterOverviewDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.mapper.mapperimpl.ChapterMapper;
import com.example.novel_website.model.Chapter;
import com.example.novel_website.model.NovelSubscriber;
import com.example.novel_website.repository.ChapterRepository;
import com.example.novel_website.service.BaseService;

@Service
public class ChapterService extends BaseService<Chapter, ObjectId, ChapterDTO>{
    @Autowired
    protected Mapper<ChapterDTO, Chapter> mapper;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    @Autowired
    NotificationService notificationService;
    
    public ChapterDTO create(ChapterDTO chapterDTO) {
        Chapter chapter = mapper.convertToEntity(chapterDTO);
        Chapter savedChapter = repository.save(chapter);
        notifySubscribers(savedChapter, savedChapter.getNovelName());
        return mapper.convertToDTO(savedChapter);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private void notifySubscribers(Chapter newChapter, String novelName) {
        for (PropertyChangeListener listener : propertyChangeSupport.getPropertyChangeListeners()) {
            if (listener instanceof NovelSubscriber && ((NovelSubscriber) listener).getNovelName().equals(novelName)) {
                listener.propertyChange(new PropertyChangeEvent(notificationService, "chapter", null, newChapter));
            }
        }
    }

    public ChapterDTO findByNovelNameAndChapterNumber(String novelName, Integer chapterNumber) 
                                    throws InterruptedException, ItemNotFoundException {
        logger.debug("Finding Chapter");

        Chapter chapter = ((ChapterRepository) repository)
                                .findByNovelNameAndChapterNumber(novelName, chapterNumber)
                                .orElseThrow(() -> new ItemNotFoundException("chapter not found"));

        logger.debug("Found Chapter: {}", chapter);
        return mapper.convertToDTO(chapter);
    }

    public List<ChapterOverviewDTO> findOverviewsByNovelName(String novelName) 
                                    throws InterruptedException{
        logger.debug("Finding Chapters");

        List<Chapter> chapters = ((ChapterRepository) repository).findOverviewsByNovelName(novelName);

        logger.debug("Found Chapters: {}", chapters);
        return convertToDTOs(chapters);
    }

    public ChapterDTO update(ChapterDTO chapterDTO) throws ItemNotFoundException {
        logger.debug("Updating chapter");
    
        Chapter updatedChapter = handleChapterProperties(chapterDTO);
        updatedChapter = repository.save(updatedChapter);
        logger.debug("Updated user successfully: {}",updatedChapter);
    
        return mapper.convertToDTO(updatedChapter);
    }
    
    private Chapter handleChapterProperties(ChapterDTO chapterDTO) throws ItemNotFoundException {
        Chapter existedChapter = findById(chapterDTO.getId());
        Chapter chapterNewInfo = mapper.convertToEntity(chapterDTO);
        return mergeChapterProperties(existedChapter, chapterNewInfo);
    }
    
    private Chapter mergeChapterProperties(Chapter existingChapter, Chapter chapterNewInfo) {
        existingChapter.setContent(chapterNewInfo.getContent() != null ? chapterNewInfo.getContent() : existingChapter.getContent());
        existingChapter.setChapterTitle(chapterNewInfo.getChapterTitle() != null ? chapterNewInfo.getChapterTitle() : existingChapter.getChapterTitle());
        return existingChapter;
    }

    public void enableChapter(String id) throws ItemNotFoundException  {
        toggleChapter(id, true);
    }

    public void disableChapter(String id) throws ItemNotFoundException  {
        toggleChapter(id, false);
    }

    private Chapter findById(ObjectId id) throws ItemNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("chapter not found"));
    }

    private void toggleChapter(String id, boolean state) throws ItemNotFoundException{
        ObjectId objectId = new ObjectId(id);
        Chapter chapter = findById(objectId);
        chapter.setActive(!chapter.isActive());
        repository.save(chapter);
    }
    
    private List<ChapterOverviewDTO> convertToDTOs(List<Chapter> chapters) {
        return chapters.stream()
                .map(((ChapterMapper) mapper)::convertChapterToChapterOverviewDTO)
                .collect(Collectors.toList());
    }
}
