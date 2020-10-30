package com.zbw.server.service;

import com.zbw.server.domain.CourseResources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link CourseResources}.
 */
public interface CourseResourcesService {

    /**
     * Save a courseResources.
     *
     * @param courseResources the entity to save.
     * @return the persisted entity.
     */
    CourseResources save(CourseResources courseResources);

    /**
     * Get all the courseResources.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CourseResources> findAll(Pageable pageable);


    /**
     * Get the "id" courseResources.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CourseResources> findOne(Long id);

    /**
     * Delete the "id" courseResources.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
