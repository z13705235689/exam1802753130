package com.zbw.server.repository;

import com.zbw.server.domain.CourseMy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CourseMy entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseMyRepository extends JpaRepository<CourseMy, Long> {

}
