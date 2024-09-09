package com.example.novel_website.mapper;

public interface Mapper<D, E> {
    
    /**
     * Converts an entity to a DTO.
     *
     * @param entity the entity to convert
     * @return the corresponding DTO
     */
    D convertToDTO(E entity);

    /**
     * Converts a DTO to an entity.
     *
     * @param dto the DTO to convert
     * @return the corresponding entity
     */
    E convertToEntity(D dto);
}
