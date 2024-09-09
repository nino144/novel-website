package com.example.novel_website.service.serviceimpl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.ReadProgressDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.exception.ReadProgressExistException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.ReadProgress;
import com.example.novel_website.repository.ReadProgressRepository;
import com.example.novel_website.service.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ReadProgressService extends BaseService<ReadProgress, ObjectId, ReadProgressDTO>{
    @Autowired
    protected Mapper<ReadProgressDTO, ReadProgress> mapper;

    public List<ReadProgressDTO> findByUserIdIsCurrentlyReadingTrue(String userId, Pageable pageable) throws InterruptedException{
        logger.debug("Finding currently reading novels by userId: {}", userId);
        
        Page<ReadProgress> currentlyReadingNovelsPage = ((ReadProgressRepository) repository)
                            .findByUserIdIsCurrentlyReading(new ObjectId(userId), pageable);

        Page<ReadProgressDTO> currentlyReadingNovelsDTOPage = currentlyReadingNovelsPage.map(mapper::convertToDTO);                 
        List<ReadProgressDTO> currentlyReadingNovelsDTOList = currentlyReadingNovelsDTOPage.getContent();

        logger.debug("Found currently reading novels by userId: {}", currentlyReadingNovelsDTOList);
        return currentlyReadingNovelsDTOList;
    }

    public List<ReadProgressDTO> findByUserIdAndIsMarkedTrue(String userId, Pageable pageable) throws InterruptedException {
        logger.debug("Finding marked novels by userId: {}", userId);
        
        Page<ReadProgress> markedNovelsPage = ((ReadProgressRepository) repository)
                                    .findByUserIdAndIsMarked(new ObjectId(userId), pageable);

        Page<ReadProgressDTO> markedNovelsDTOPage = markedNovelsPage.map(mapper::convertToDTO);
        List<ReadProgressDTO> markedNovelsDTOList = markedNovelsDTOPage.getContent();

        logger.debug("Found marked novels by userId: {}", markedNovelsDTOList);
        return markedNovelsDTOList;
    }

    public List<ReadProgressDTO> findByUserId(String userId, Pageable pageable) throws InterruptedException {
        logger.debug("Finding novels by userId: {}", userId);
        
        Page<ReadProgress> novelsPage = ((ReadProgressRepository) repository)
                                    .findByUserId(new ObjectId(userId), pageable);

        Page<ReadProgressDTO> novelsDTOPage = novelsPage.map(mapper::convertToDTO);
        List<ReadProgressDTO> novelsDTOList = novelsDTOPage.getContent();

        logger.debug("Found novels by userId: {}", novelsDTOList);
        return novelsDTOList;
    }

    // private List<ReadProgressDTO> convertToDTOs(List<ReadProgress> novels) {
    //     return novels.stream()
    //             .map(mapper::convertToDTO)
    //             .collect(Collectors.toList());
    // }

    public ReadProgressDTO create(ReadProgressDTO readProgressDTO) throws ReadProgressExistException {
        logger.info("Check if Read Progress already existed" + readProgressDTO.getNovelName() +" " +readProgressDTO.getUserId()+ " " +readProgressDTO.getChapter());
        existsReadProgress(readProgressDTO.getNovelName(), readProgressDTO.getUserId(), readProgressDTO.getChapter());

        logger.info("Creating ReadProgress");
        ReadProgress readProgress = mapper.convertToEntity(readProgressDTO);
        ReadProgress savedReadProgress = repository.save(readProgress);

        logger.info("Created Chapter sucessfully");
        return mapper.convertToDTO(savedReadProgress);
    }

    public void delete(String id) throws ItemNotFoundException {
        logger.info("Deleting Read Progress: {}", id);
        ReadProgress readProgress = findById(new ObjectId(id));
        repository.delete(readProgress);
        logger.info("Successfully deleted Read Progress: {}", readProgress);
    }

    private ReadProgress findById(ObjectId id) throws ItemNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Read Progress not found"));
    }

    public void existsReadProgress(String novelName, ObjectId userId, Integer chapter) throws ReadProgressExistException {
        ReadProgress exists = ((ReadProgressRepository) repository).existsByNovelNameAndUserIdAndChapter(novelName, userId, chapter);
        
        if (exists!= null) {
            throw new ReadProgressExistException("Read Progress existed");
        }
    }
}
