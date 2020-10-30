package com.zbw.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 课程大纲
 */
@ApiModel(description = "课程大纲")
@Entity
@Table(name = "course_outline")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CourseOutline implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 章
     */
    @ApiModelProperty(value = "章")
    @Column(name = "chapter")
    private Long chapter;

    /**
     * 节
     */
    @ApiModelProperty(value = "节")
    @Column(name = "section")
    private Long section;

    @ManyToOne
    @JsonIgnoreProperties(value = "courseOutlines", allowSetters = true)
    private CourseInfo outline;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapter() {
        return chapter;
    }

    public CourseOutline chapter(Long chapter) {
        this.chapter = chapter;
        return this;
    }

    public void setChapter(Long chapter) {
        this.chapter = chapter;
    }

    public Long getSection() {
        return section;
    }

    public CourseOutline section(Long section) {
        this.section = section;
        return this;
    }

    public void setSection(Long section) {
        this.section = section;
    }

    public CourseInfo getOutline() {
        return outline;
    }

    public CourseOutline outline(CourseInfo courseInfo) {
        this.outline = courseInfo;
        return this;
    }

    public void setOutline(CourseInfo courseInfo) {
        this.outline = courseInfo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseOutline)) {
            return false;
        }
        return id != null && id.equals(((CourseOutline) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourseOutline{" +
            "id=" + getId() +
            ", chapter=" + getChapter() +
            ", section=" + getSection() +
            "}";
    }
}
