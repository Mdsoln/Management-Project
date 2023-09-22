package com.muddy.databaserelation.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materials")

public class CourseMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialId;
    private String url;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "code"
    )
    private Course course;

    public CourseMaterials() {
    }

    public CourseMaterials(Long materialId, String url, Course course) {
        this.materialId = materialId;
        this.url = url;
        this.course = course;
    }

    public CourseMaterials(String url, Course course) {
        this.url = url;
        this.course = course;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseMaterials{" +
                "materialId=" + materialId +
                ", url='" + url + '\'' +
                '}';
    }
}
