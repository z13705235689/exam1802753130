package com.zbw.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 课程资源
 */
@ApiModel(description = "课程资源")
@Entity
@Table(name = "course_resources")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CourseResources implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resources_type")
    private String resourcesType;

    @Column(name = "resources_name")
    private String resourcesName;

    @Column(name = "resources_url")
    private String resourcesUrl;

    @Column(name = "resources_time")
    private ZonedDateTime resourcesTime;

    @ManyToOne
    @JsonIgnoreProperties(value = "courseResources", allowSetters = true)
    private CourseOutline resources;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourcesType() {
        return resourcesType;
    }

    public CourseResources resourcesType(String resourcesType) {
        this.resourcesType = resourcesType;
        return this;
    }

    public void setResourcesType(String resourcesType) {
        this.resourcesType = resourcesType;
    }

    public String getResourcesName() {
        return resourcesName;
    }

    public CourseResources resourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
        return this;
    }

    public void setResourcesName(String resourcesName) {
        this.resourcesName = resourcesName;
    }

    public String getResourcesUrl() {
        return resourcesUrl;
    }

    public CourseResources resourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
        return this;
    }

    public void setResourcesUrl(String resourcesUrl) {
        this.resourcesUrl = resourcesUrl;
    }

    public ZonedDateTime getResourcesTime() {
        return resourcesTime;
    }

    public CourseResources resourcesTime(ZonedDateTime resourcesTime) {
        this.resourcesTime = resourcesTime;
        return this;
    }

    public void setResourcesTime(ZonedDateTime resourcesTime) {
        this.resourcesTime = resourcesTime;
    }

    public CourseOutline getResources() {
        return resources;
    }

    public CourseResources resources(CourseOutline courseOutline) {
        this.resources = courseOutline;
        return this;
    }

    public void setResources(CourseOutline courseOutline) {
        this.resources = courseOutline;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseResources)) {
            return false;
        }
        return id != null && id.equals(((CourseResources) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourseResources{" +
            "id=" + getId() +
            ", resourcesType='" + getResourcesType() + "'" +
            ", resourcesName='" + getResourcesName() + "'" +
            ", resourcesUrl='" + getResourcesUrl() + "'" +
            ", resourcesTime='" + getResourcesTime() + "'" +
            "}";
    }
}
