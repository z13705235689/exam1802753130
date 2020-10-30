package com.zbw.server.service.impl;

import com.zbw.server.domain.CourseResources;
import com.zbw.server.repository.CourseResourcesRepository;
import com.zbw.server.service.CourseResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CourseResources}.
 */
@Service
@Transactional
public class CourseResourcesServiceImpl implements CourseResourcesService {

    private final Logger log = LoggerFactory.getLogger(CourseResourcesServiceImpl.class);

    private final CourseResourcesRepository courseResourcesRepository;

    public CourseResourcesServiceImpl(CourseResourcesRepository courseResourcesRepository) {
        this.courseResourcesRepository = courseResourcesRepository;
    }

    @Override
    public CourseResources save(CourseResources courseResources) {
        log.debug("Request to save CourseResources : {}", courseResources);
        return courseResourcesRepository.save(courseResources);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseResources> findAll(Pageable pageable) {
        log.debug("Request to get all CourseResources");
        return courseResourcesRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CourseResources> findOne(Long id) {
        log.debug("Request to get CourseResources : {}", id);
        return courseResourcesRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseResources : {}", id);
        courseResourcesRepository.deleteById(id);
    }
}
