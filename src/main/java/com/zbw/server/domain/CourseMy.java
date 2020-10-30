package com.zbw.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 我加入的课程
 */
@ApiModel(description = "我加入的课程")
@Entity
@Table(name = "course_my")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CourseMy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = "courseMies", allowSetters = true)
    private UserAccount account;

    @ManyToOne
    @JsonIgnoreProperties(value = "courseMies", allowSetters = true)
    private CourseInfo course;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserAccount getAccount() {
        return account;
    }

    public CourseMy account(UserAccount userAccount) {
        this.account = userAccount;
        return this;
    }

    public void setAccount(UserAccount userAccount) {
        this.account = userAccount;
    }

    public CourseInfo getCourse() {
        return course;
    }

    public CourseMy course(CourseInfo courseInfo) {
        this.course = courseInfo;
        return this;
    }

    public void setCourse(CourseInfo courseInfo) {
        this.course = courseInfo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseMy)) {
            return false;
        }
        return id != null && id.equals(((CourseMy) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourseMy{" +
            "id=" + getId() +
            "}";
    }
}
