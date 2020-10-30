package com.zbw.server.service;

import com.zbw.server.domain.CourseMy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link CourseMy}.
 */
public interface CourseMyService {

    /**
     * Save a courseMy.
     *
     * @param courseMy the entity to save.
     * @return the persisted entity.
     */
    CourseMy save(CourseMy courseMy);

    /**
     * Get all the courseMies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CourseMy> findAll(Pageable pageable);


    /**
     * Get the "id" courseMy.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CourseMy> findOne(Long id);

    /**
     * Delete the "id" courseMy.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
