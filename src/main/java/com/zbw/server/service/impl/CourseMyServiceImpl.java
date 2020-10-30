package com.zbw.server.service.impl;

import com.zbw.server.domain.CourseMy;
import com.zbw.server.repository.CourseMyRepository;
import com.zbw.server.service.CourseMyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CourseMy}.
 */
@Service
@Transactional
public class CourseMyServiceImpl implements CourseMyService {

    private final Logger log = LoggerFactory.getLogger(CourseMyServiceImpl.class);

    private final CourseMyRepository courseMyRepository;

    public CourseMyServiceImpl(CourseMyRepository courseMyRepository) {
        this.courseMyRepository = courseMyRepository;
    }

    @Override
    public CourseMy save(CourseMy courseMy) {
        log.debug("Request to save CourseMy : {}", courseMy);
        return courseMyRepository.save(courseMy);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseMy> findAll(Pageable pageable) {
        log.debug("Request to get all CourseMies");
        return courseMyRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CourseMy> findOne(Long id) {
        log.debug("Request to get CourseMy : {}", id);
        return courseMyRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseMy : {}", id);
        courseMyRepository.deleteById(id);
    }
}
