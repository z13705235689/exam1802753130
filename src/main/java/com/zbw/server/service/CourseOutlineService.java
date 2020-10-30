package com.zbw.server.service;

import com.zbw.server.domain.CourseOutline;
import com.zbw.server.service.dto.OutlineTree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link CourseOutline}.
 */
public interface CourseOutlineService {

    /**
     * Save a courseOutline.
     *
     * @param courseOutline the entity to save.
     * @return the persisted entity.
     */
    CourseOutline save(CourseOutline courseOutline);

    /**
     * Get all the courseOutlines.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CourseOutline> findAll(Pageable pageable);


    /**
     * Get the "id" courseOutline.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CourseOutline> findOne(Long id);

    /**
     * Delete the "id" courseOutline.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<OutlineTree> getTree(Long chapter,Long courseID);
}
