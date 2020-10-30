package com.zbw.server.service.impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.zbw.server.domain.CourseOutline;
import com.zbw.server.repository.CourseOutlineRepository;
import com.zbw.server.service.CourseOutlineService;
import com.zbw.server.service.dto.OutlineTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CourseOutline}.
 */
@Service
@Transactional
public class CourseOutlineServiceImpl implements CourseOutlineService {

    private final Logger log = LoggerFactory.getLogger(CourseOutlineServiceImpl.class);

    private final CourseOutlineRepository courseOutlineRepository;
    private final JdbcTemplate jdbcTemplate;
    public CourseOutlineServiceImpl(CourseOutlineRepository courseOutlineRepository, JdbcTemplate jdbcTemplate) {
        this.courseOutlineRepository = courseOutlineRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CourseOutline save(CourseOutline courseOutline) {
        log.debug("Request to save CourseOutline : {}", courseOutline);
        return courseOutlineRepository.save(courseOutline);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourseOutline> findAll(Pageable pageable) {
        log.debug("Request to get all CourseOutlines");
        return courseOutlineRepository.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<CourseOutline> findOne(Long id) {
        log.debug("Request to get CourseOutline : {}", id);
        return courseOutlineRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseOutline : {}", id);
        courseOutlineRepository.deleteById(id);
    }

    @Override
    public List<OutlineTree> getTree(Long chapter, Long courseID) {
        String sql="select uo.id, " +
            "       uo.chapter, " +
            "       uo.section, " +
            "       (select count(*) from course_outline where course_outline.outline_id=uo.id) as leaf " +
            "from course_outline uo " +
            "where uo.chapter="+chapter+" AND uo.outline_id="+courseID;
//        String sql="select id," +
//            "       comment_pid," +
//            "       comment_content," +
//            "      (select count(*) from user_content_comment where comment_pid=ucc.id and content_id="+contentId+") as leaf " +
//            "from user_content_comment ucc " +
//            "where ucc.comment_pid="+pid + " and ucc.content_id="+contentId;
        List<Map<String,Object>> sqlResult=this.jdbcTemplate.queryForList(sql);

        List<OutlineTree> result=new ArrayList<>();
        if(sqlResult!=null && !sqlResult.isEmpty()){
            for(Map<String, Object> temp:sqlResult){
                OutlineTree outlineTree=new OutlineTree();
                outlineTree.setId(TypeUtils.castToLong(temp.get("id")));
                outlineTree.setChapter(TypeUtils.castToLong(temp.get("chapter")));
                outlineTree.setSection(TypeUtils.castToLong(temp.get("section")));
                Integer leafCount= TypeUtils.castToInt(temp.get("leaf"));
                System.out.println("leafCount: "+leafCount);
                if(leafCount>0)
                    outlineTree.setLeaf(false);
                else
                    outlineTree.setLeaf(true);
                //将子存入children
                if(!outlineTree.isLeaf()){
                    outlineTree.setChildren(getTree(outlineTree.getChapter(),courseID));
                }
                result.add(outlineTree);
            }
        }

        return result;
    }
}
