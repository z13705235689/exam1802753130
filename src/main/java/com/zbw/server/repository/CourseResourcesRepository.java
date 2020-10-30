package com.zbw.server.repository;

import com.zbw.server.domain.CourseResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CourseResources entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseResourcesRepository extends JpaRepository<CourseResources, Long> {
}
