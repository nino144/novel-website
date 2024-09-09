package com.example.novel_website.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.NovelDTO;
import com.example.novel_website.enums.Interaction;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Novel;
import com.example.novel_website.repository.NovelRepository;
import com.example.novel_website.service.BaseService;

@Service
public class NovelService extends BaseService<Novel, String, NovelDTO>  {
    @Autowired
    protected Mapper<NovelDTO, Novel> mapper;

    @Autowired
    NovelInteractionService novelInteractionService;

    public NovelDTO findByName(String novelName) throws InterruptedException{
        logger.debug("Finding novel by name: {}", novelName);
        
        Novel novel = ((NovelRepository) repository).findByName(novelName);
        NovelDTO novelDTO = mapper.convertToDTO(novel);

        logger.debug("Found novel by that name: {}", novelDTO);
        return novelDTO;
    }

    public List<NovelDTO> findEnabledNovels(Pageable pageable) throws InterruptedException{
        logger.debug("Finding enabled novels");

        Page<Novel> novelsPage = ((NovelRepository) repository).findEnabledNovels(pageable);
        Page<NovelDTO> novelsDTOPage = novelsPage.map(mapper::convertToDTO);
        List<NovelDTO> novelsDTOList = novelsDTOPage.getContent();

        logger.debug("Found enabled novels: {}", novelsDTOList);
        return novelsDTOList;
    }

    public List<NovelDTO> queryNovelsByTypeAndDatetime(Interaction interactionType, String datetime, Pageable pageable) throws InterruptedException {
        logger.debug("Finding enabled novels by name");

        List<String> novelsName = ((NovelInteractionService) novelInteractionService)
                                        .getNovelsName(interactionType, datetime);
        
        Page<Novel> orderedNovelsPage = getNovelsPage(novelsName, pageable);

        Page<NovelDTO> orderedNovelsDTOPage = orderedNovelsPage.map(mapper::convertToDTO);

        List<NovelDTO> orderedNovelsDTOList = orderedNovelsDTOPage.getContent();

        logger.info("Found novels: {}", orderedNovelsDTOList);
        return orderedNovelsDTOList;
    }

    private Page<Novel> getNovelsPage(List<String> novelsName, Pageable pageable) {
        List<Novel> orderedNovels = new ArrayList<>();
    
        for (String novelName : novelsName) {
            // Fetching a single novel by name
            Novel novel = ((NovelRepository) repository).findEnabledNovelByName(novelName);
            if (novel != null) {
                orderedNovels.add(novel);
            }
        }
    
        // Calculate total elements
        long totalElements = orderedNovels.size();
    
        // Calculate the start and end index for the requested page
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), orderedNovels.size());
        
        // Create a sublist for the requested page
        List<Novel> pagedNovels = orderedNovels.subList(start, end);
    
        // Create a new PageImpl with the paged novels, pageable info, and total elements
        return new PageImpl<>(pagedNovels, pageable, totalElements);
    }

    // private List<NovelDTO> convertToDTOs(List<Novel> novels) {
    //     return novels.stream()
    //             .map(mapper::convertToDTO)
    //             .collect(Collectors.toList());
    // }

    public NovelDTO create(NovelDTO novelDTO) {
        logger.info("Creating novel: {}", novelDTO.getName());
        Novel novel = mapper.convertToEntity(novelDTO);
        Novel savedNovel = repository.save(novel);
        logger.info("Created novel sucessfully: {}", savedNovel);
        return mapper.convertToDTO(savedNovel);
    }

    public void enableNovel(String name)  {
        toggleNovel(name, true);
    }

    public void disableNovel(String name)  {
        toggleNovel(name, false);
    }

    private void toggleNovel(String name, boolean state){
        Novel novel = ((NovelRepository) repository).findByName(name);
        novel.setActive(!novel.isActive());
        repository.save(novel);
    }

}