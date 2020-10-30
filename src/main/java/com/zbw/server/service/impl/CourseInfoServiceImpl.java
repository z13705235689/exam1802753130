package com.zbw.server.service.impl;

import com.zbw.server.domain.CourseInfo;
import com.zbw.server.repository.CourseInfoRepository;
import com.zbw.server.repository.CourseMyRepository;
import com.zbw.server.service.CourseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CourseInfo}.
 */
@Service
@Transactional
public class CourseInfoServiceImpl implements CourseInfoService {

    private final Logger log = LoggerFactory.getLogger(CourseInfoServiceImpl.class);

    private final CourseInfoRepository courseInfoRepository;
    private final CourseMyRepository courseMyRepository;

    public CourseInfoServiceImpl(CourseInfoRepository courseInfoRepository, CourseMyRepository courseMyRepository) {
        this.courseInfoRepository = courseInfoRepository;
        this.courseMyRepository = courseMyRepository;
    }

    @Override
    public CourseInfo save(CourseInfo courseInfo) {
        log.debug("Request to save CourseInfo : {}", courseInfo);
        return courseInfoRepository.save(courseInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseInfo> findAll(Pageable pageable) {
        log.debug("Request to get all CourseInfos");
        return courseInfoRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CourseInfo> findOne(Long id) {
        log.debug("Request to get CourseInfo : {}", id);
        return courseInfoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseInfo : {}", id);
        courseInfoRepository.deleteById(id);
    }

    @Override
    public CourseInfo add(String name, Long num, String major, String institutions, String type) {
        CourseInfo courseInfo=new CourseInfo();
        courseInfo.setCourseName(name);
        courseInfo.setCourseNum(num);
        courseInfo.setCourseMajor(major);
        courseInfo.setCourseInstitutions(institutions);
        courseInfo.setCourseType(type);
        System.out.println(courseInfo.toString());
        return this.courseInfoRepository.save(courseInfo);
    }

    @Override
    public Page<CourseInfo> getMy(String login,Integer index, Integer size) {
        Pageable pageable=PageRequest.of(index,size);
        Page<CourseInfo> result=this.courseInfoRepository.getMyCourse(pageable,login);
        return result;
    }
}
