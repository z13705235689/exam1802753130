package com.zbw.server.repository;

import com.zbw.server.domain.CourseOutline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CourseOutline entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseOutlineRepository extends JpaRepository<CourseOutline, Long> {
}
