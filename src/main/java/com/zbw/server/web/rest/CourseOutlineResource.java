package com.zbw.server.web.rest;

import com.zbw.server.domain.CourseOutline;
import com.zbw.server.service.CourseOutlineService;
import com.zbw.server.service.dto.OutlineTree;
import com.zbw.server.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.zbw.server.domain.CourseOutline}.
 */
@RestController
@RequestMapping("/api")
public class CourseOutlineResource {

    private final Logger log = LoggerFactory.getLogger(CourseOutlineResource.class);

    private static final String ENTITY_NAME = "courseOutline";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CourseOutlineService courseOutlineService;

    public CourseOutlineResource(CourseOutlineService courseOutlineService) {
        this.courseOutlineService = courseOutlineService;
    }

    /**
     * {@code POST  /course-outlines} : Create a new courseOutline.
     *
     * @param courseOutline the courseOutline to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new courseOutline, or with status {@code 400 (Bad Request)} if the courseOutline has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/course-outlines")
    public ResponseEntity<CourseOutline> createCourseOutline(@RequestBody CourseOutline courseOutline) throws URISyntaxException {
        log.debug("REST request to save CourseOutline : {}", courseOutline);
        if (courseOutline.getId() != null) {
            throw new BadRequestAlertException("A new courseOutline cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CourseOutline result = courseOutlineService.save(courseOutline);
        return ResponseEntity.created(new URI("/api/course-outlines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /course-outlines} : Updates an existing courseOutline.
     *
     * @param courseOutline the courseOutline to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated courseOutline,
     * or with status {@code 400 (Bad Request)} if the courseOutline is not valid,
     * or with status {@code 500 (Internal Server Error)} if the courseOutline couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/course-outlines")
    public ResponseEntity<CourseOutline> updateCourseOutline(@RequestBody CourseOutline courseOutline) throws URISyntaxException {
        log.debug("REST request to update CourseOutline : {}", courseOutline);
        if (courseOutline.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CourseOutline result = courseOutlineService.save(courseOutline);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, courseOutline.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /course-outlines} : get all the courseOutlines.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of courseOutlines in body.
     */
    @GetMapping("/course-outlines")
    public ResponseEntity<List<CourseOutline>> getAllCourseOutlines(Pageable pageable) {
        log.debug("REST request to get a page of CourseOutlines");
        Page<CourseOutline> page = courseOutlineService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /course-outlines/:id} : get the "id" courseOutline.
     *
     * @param id the id of the courseOutline to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the courseOutline, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/course-outlines/{id}")
    public ResponseEntity getCourseOutline(@PathVariable Long id) {
        Optional<CourseOutline> courseOutline = courseOutlineService.findOne(id);
        return ResponseUtil.wrapOrNotFound(courseOutline);
    }

    /**
     * {@code DELETE  /course-outlines/:id} : delete the "id" courseOutline.
     *
     * @param id the id of the courseOutline to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/course-outlines/{id}")
    public ResponseEntity<Void> deleteCourseOutline(@PathVariable Long id) {
        log.debug("REST request to delete CourseOutline : {}", id);
        courseOutlineService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    @GetMapping("/course-outlines/getTree")
    @ApiOperation("查询单门课程的大纲")
    public ResponseEntity getTree(Long courseId){
        List<OutlineTree> result=this.courseOutlineService.getTree(0l,courseId);
        return ResponseEntity.ok(result);
    }
}
