package com.example.novel_website.service.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.novel_website.dto.TraitDTO;
import com.example.novel_website.exception.ItemNotFoundException;
import com.example.novel_website.mapper.Mapper;
import com.example.novel_website.model.Trait;
import com.example.novel_website.repository.TraitRepository;
import com.example.novel_website.service.BaseService;

import org.bson.types.ObjectId;

import org.springframework.data.domain.Page;

@Service
public class TraitService extends BaseService<Trait, ObjectId, TraitDTO>{
    @Autowired
    protected Mapper<TraitDTO, Trait> mapper;

    public TraitDTO create(TraitDTO traitDTO) {
        logger.debug("Create new trait: {}", traitDTO);
        Trait trait = mapper.convertToEntity(traitDTO);
        Trait createdTrait =  repository.save(trait);
        logger.debug("Create Trait sucessfully: {}", createdTrait);
        return mapper.convertToDTO(createdTrait);
    }

    public TraitDTO findById(ObjectId id) throws ItemNotFoundException{
        Optional<Trait> optionalTrait = repository.findById(id);

        if (optionalTrait.isEmpty()) {
            logger.error("Trait not found");
            throw new ItemNotFoundException("Trait not found");
        }

        return mapper.convertToDTO(optionalTrait.get());
    }

    public List<TraitDTO> findByName(String traitName, Pageable pageable) throws InterruptedException{
        logger.debug("Finding trait by trait name: {}", traitName);

        Page<Trait> traitsPage =  ((TraitRepository) repository).findByName(traitName, pageable);
        Page<TraitDTO> traitsDTOPage = traitsPage.map(mapper::convertToDTO);
        //convertToDTOs(traitsPage);

        List<TraitDTO> traitsDTOList = traitsDTOPage.getContent();
        logger.debug("Found traits: {}", traitsDTOList);
        return traitsDTOList;
    }

    public List<TraitDTO> findEnabledTraits(Pageable pageable) throws InterruptedException{
        logger.debug("Finding enabled traits");

        Page<Trait> traitsPage = ((TraitRepository) repository).findEnabledTraits(pageable);
        Page<TraitDTO> traitsDTOPage = traitsPage.map(mapper::convertToDTO);
        //convertToDTOs(traits);
        List<TraitDTO> traitsDTOList = traitsDTOPage.getContent();

        logger.debug("Found enabled traits: {}", traitsDTOList);
        return traitsDTOList;
    }
    
    private List<TraitDTO> convertToDTOs(List<Trait> traits) {
        return traits.stream()
                .map(mapper::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private List<Trait> convertToEntities(List<TraitDTO> traitsDTO) {
        return traitsDTO.stream()
                .map(mapper::convertToEntity)
                .collect(Collectors.toList());
    }

    public TraitDTO update(TraitDTO traitDTO) throws ItemNotFoundException, InterruptedException {
        logger.debug("Updating trait");

        updateTraitsIfNameChange(traitDTO);

        Trait trait = mapper.convertToEntity(traitDTO);

        Trait updatedTrait = repository.save(trait);
        logger.debug("Updated trait successfully: {}", updatedTrait);
        return mapper.convertToDTO(updatedTrait);
    }

    private void updateTraitsIfNameChange(TraitDTO traitDTO) throws ItemNotFoundException, InterruptedException {
        TraitDTO existedTraitDTO = findById(traitDTO.getId());

        if (!traitDTO.getName().equalsIgnoreCase(existedTraitDTO.getName())) {
            updateTraitNameAndAssociatedTraits(traitDTO.getName(), existedTraitDTO.getName());
        }
    }

    public List<TraitDTO> findAllByName(String traitName) throws InterruptedException{
        logger.debug("Finding trait by trait name: {}", traitName);

        List<Trait> traits =  ((TraitRepository) repository).findAllByName(traitName);
        List<TraitDTO> traitsDTO = convertToDTOs(traits);

        logger.debug("Found traits: {}", traitsDTO);
        return traitsDTO;
    }

    private void updateTraitNameAndAssociatedTraits(String newName, String oldName) throws InterruptedException{
        logger.debug("Updating name of the associated traits");
      
        List<Trait> associatedTraits = convertToEntities(findAllByName(oldName));
        updateTraits(newName, associatedTraits);
      
        logger.debug("Updated name successfully for associate traits");
    }
      
    private void updateTraits(String newName, List<Trait> associatedTraits) {
        logger.info("Starting sequential update of traits with new name: {}", newName);
    
        for (Trait associatedTrait : associatedTraits) {
            associatedTrait.setName(newName);
            logger.debug("Updating trait: {}", associatedTrait.getName()); // Log specific trait name
            repository.save(associatedTrait);
        }
    
        logger.info("Sequential update of traits completed.");
    }

    public void enableTrait(ObjectId id) throws ItemNotFoundException  {
        toggleTrait(id, true);
    }

    public void disableTrait(ObjectId id) throws ItemNotFoundException  {
        toggleTrait(id, false);
    }

    private void toggleTrait(ObjectId id, boolean state) throws ItemNotFoundException {
        Trait trait = mapper.convertToEntity(findById(id));
        trait.setActive(!trait.isActive());
        repository.save(trait);
    }
}
