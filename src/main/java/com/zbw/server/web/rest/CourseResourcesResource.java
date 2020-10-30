package com.zbw.server.web.rest;

import com.zbw.server.domain.CourseResources;
import com.zbw.server.service.CourseResourcesService;
import com.zbw.server.service.dto.FileDTO;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * REST controller for managing {@link com.zbw.server.domain.CourseResources}.
 */
@RestController
@RequestMapping("/api")
public class CourseResourcesResource {

    private final Logger log = LoggerFactory.getLogger(CourseResourcesResource.class);

    private static final String ENTITY_NAME = "courseResources";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CourseResourcesService courseResourcesService;


    public CourseResourcesResource(CourseResourcesService courseResourcesService) {
        this.courseResourcesService = courseResourcesService;
    }

    /**
     * {@code POST  /course-resources} : Create a new courseResources.
     *
     * @param courseResources the courseResources to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new courseResources, or with status {@code 400 (Bad Request)} if the courseResources has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/course-resources")
    public ResponseEntity<CourseResources> createCourseResources(@RequestBody CourseResources courseResources) throws URISyntaxException {
        log.debug("REST request to save CourseResources : {}", courseResources);
        if (courseResources.getId() != null) {
            throw new BadRequestAlertException("A new courseResources cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CourseResources result = courseResourcesService.save(courseResources);
        return ResponseEntity.created(new URI("/api/course-resources/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /course-resources} : Updates an existing courseResources.
     *
     * @param courseResources the courseResources to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated courseResources,
     * or with status {@code 400 (Bad Request)} if the courseResources is not valid,
     * or with status {@code 500 (Internal Server Error)} if the courseResources couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/course-resources")
    public ResponseEntity<CourseResources> updateCourseResources(@RequestBody CourseResources courseResources) throws URISyntaxException {
        log.debug("REST request to update CourseResources : {}", courseResources);
        if (courseResources.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CourseResources result = courseResourcesService.save(courseResources);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, courseResources.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /course-resources} : get all the courseResources.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of courseResources in body.
     */
    @GetMapping("/course-resources")
    public ResponseEntity<List<CourseResources>> getAllCourseResources(Pageable pageable) {
        log.debug("REST request to get a page of CourseResources");
        Page<CourseResources> page = courseResourcesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /course-resources/:id} : get the "id" courseResources.
     *
     * @param id the id of the courseResources to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the courseResources, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/course-resources/{id}")
    public ResponseEntity<CourseResources> getCourseResources(@PathVariable Long id) {
        log.debug("REST request to get CourseResources : {}", id);
        Optional<CourseResources> courseResources = courseResourcesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(courseResources);
    }

    /**
     * {@code DELETE  /course-resources/:id} : delete the "id" courseResources.
     *
     * @param id the id of the courseResources to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/course-resources/{id}")
    public ResponseEntity<Void> deleteCourseResources(@PathVariable Long id) {
        log.debug("REST request to delete CourseResources : {}", id);
        courseResourcesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
    @Value("${file.vpath}")
    private String vpath;
    @Value("${file.diskPath}")
    private String diskPath;
    @PutMapping("/course-resources/upload")
    public ResponseEntity upload(MultipartFile multipartFile){

            if (multipartFile.isEmpty()) {
                return ResponseEntity.badRequest().body("文件不能为空");
            }

            //返回的文件信息
            FileDTO result = new FileDTO();
            result.setSize(multipartFile.getSize());
            result.setZonedDateTime(ZonedDateTime.now());
            //获取上传的文件名
            String name = multipartFile.getOriginalFilename();

            //后缀名
            String extName = name.substring(name.lastIndexOf(".") + 1);

            //使用UUID生成新的文件名
            String newFileName = UUID.randomUUID() + "." + extName;

            //使用新的文件名，将文件写入指定目录
            File file = new File(diskPath, newFileName);
            try {
                //保存完成
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //构成服务器访问地址返回
            String resultPath = vpath + "/" + newFileName;

            result.setOriginName(name);
            result.setFileName(newFileName);
            result.setExtName(extName);
            result.setPath(resultPath);

        return ResponseEntity.ok(result);
    }
}
