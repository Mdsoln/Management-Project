package com.muddy.databaserelation.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String courseTitle;
    private Integer credit;
    @OneToOne(
            mappedBy = "course",cascade = CascadeType.ALL
    )
    private CourseMaterials materials;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacher_id"
    )
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "code"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> studentList;

    public void addStudent(Student student){
        if (studentList == null) studentList = new ArrayList<>();
        studentList.add(student);
    }
    public Course() {
    }

    public Course(Long code, String courseTitle, Integer credit, CourseMaterials materials, Teacher teacher, List<Student> studentList) {
        this.code = code;
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.materials = materials;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public Course(String courseTitle, Integer credit, CourseMaterials materials, Teacher teacher, List<Student> studentList) {
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.materials = materials;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public CourseMaterials getMaterials() {
        return materials;
    }

    public void setMaterials(CourseMaterials materials) {
        this.materials = materials;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code=" + code +
                ", courseTitle='" + courseTitle + '\'' +
                ", credit=" + credit +
                ", materials=" + materials +
                ", teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
    }
}
