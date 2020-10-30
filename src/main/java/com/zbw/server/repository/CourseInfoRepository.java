package com.zbw.server.repository;

import com.zbw.server.domain.CourseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CourseInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {
//    CourseInfo
    @Query("select cm.course from CourseMy cm where cm.account.userName=:login")
    Page<CourseInfo> getMyCourse(Pageable pageable, @Param("login") String login);
}
