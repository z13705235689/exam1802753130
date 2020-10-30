package com.zbw.server.web.rest;

import com.zbw.server.domain.CourseMy;
import com.zbw.server.service.CourseMyService;
import com.zbw.server.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
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
 * REST controller for managing {@link com.zbw.server.domain.CourseMy}.
 */
@RestController
@RequestMapping("/api")
public class CourseMyResource {

    private final Logger log = LoggerFactory.getLogger(CourseMyResource.class);

    private static final String ENTITY_NAME = "courseMy";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CourseMyService courseMyService;

    public CourseMyResource(CourseMyService courseMyService) {
        this.courseMyService = courseMyService;
    }

    /**
     * {@code POST  /course-mies} : Create a new courseMy.
     *
     * @param courseMy the courseMy to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new courseMy, or with status {@code 400 (Bad Request)} if the courseMy has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/course-mies")
    public ResponseEntity<CourseMy> createCourseMy(@RequestBody CourseMy courseMy) throws URISyntaxException {
        log.debug("REST request to save CourseMy : {}", courseMy);
        if (courseMy.getId() != null) {
            throw new BadRequestAlertException("A new courseMy cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CourseMy result = courseMyService.save(courseMy);
        return ResponseEntity.created(new URI("/api/course-mies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /course-mies} : Updates an existing courseMy.
     *
     * @param courseMy the courseMy to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated courseMy,
     * or with status {@code 400 (Bad Request)} if the courseMy is not valid,
     * or with status {@code 500 (Internal Server Error)} if the courseMy couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/course-mies")
    public ResponseEntity<CourseMy> updateCourseMy(@RequestBody CourseMy courseMy) throws URISyntaxException {
        log.debug("REST request to update CourseMy : {}", courseMy);
        if (courseMy.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CourseMy result = courseMyService.save(courseMy);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, courseMy.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /course-mies} : get all the courseMies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of courseMies in body.
     */
    @GetMapping("/course-mies")
    public ResponseEntity<List<CourseMy>> getAllCourseMies(Pageable pageable) {
        log.debug("REST request to get a page of CourseMies");
        Page<CourseMy> page = courseMyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /course-mies/:id} : get the "id" courseMy.
     *
     * @param id the id of the courseMy to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the courseMy, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/course-mies/{id}")
    public ResponseEntity<CourseMy> getCourseMy(@PathVariable Long id) {
        log.debug("REST request to get CourseMy : {}", id);
        Optional<CourseMy> courseMy = courseMyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(courseMy);
    }

    /**
     * {@code DELETE  /course-mies/:id} : delete the "id" courseMy.
     *
     * @param id the id of the courseMy to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/course-mies/{id}")
    public ResponseEntity<Void> deleteCourseMy(@PathVariable Long id) {
        log.debug("REST request to delete CourseMy : {}", id);
        courseMyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

}
