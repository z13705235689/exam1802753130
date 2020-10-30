package com.zbw.server.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A CourseInfo.
 */
@Entity
@Table(name = "course_info")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CourseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_num")
    private Long courseNum;

    @Column(name = "course_major")
    private String courseMajor;

    @Column(name = "course_institutions")
    private String courseInstitutions;

    @Column(name = "course_type")
    private String courseType;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public CourseInfo courseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseNum() {
        return courseNum;
    }

    public CourseInfo courseNum(Long courseNum) {
        this.courseNum = courseNum;
        return this;
    }

    public void setCourseNum(Long courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseMajor() {
        return courseMajor;
    }

    public CourseInfo courseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
        return this;
    }

    public void setCourseMajor(String courseMajor) {
        this.courseMajor = courseMajor;
    }

    public String getCourseInstitutions() {
        return courseInstitutions;
    }

    public CourseInfo courseInstitutions(String courseInstitutions) {
        this.courseInstitutions = courseInstitutions;
        return this;
    }

    public void setCourseInstitutions(String courseInstitutions) {
        this.courseInstitutions = courseInstitutions;
    }

    public String getCourseType() {
        return courseType;
    }

    public CourseInfo courseType(String courseType) {
        this.courseType = courseType;
        return this;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseInfo)) {
            return false;
        }
        return id != null && id.equals(((CourseInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourseInfo{" +
            "id=" + getId() +
            ", courseName='" + getCourseName() + "'" +
            ", courseNum=" + getCourseNum() +
            ", courseMajor='" + getCourseMajor() + "'" +
            ", courseInstitutions='" + getCourseInstitutions() + "'" +
            ", courseType='" + getCourseType() + "'" +
            "}";
    }
}
