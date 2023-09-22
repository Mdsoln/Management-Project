package com.muddy.databaserelation.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;
    @Column(name = "t_name",nullable = false)
    private String t_name;
    @Column(name = "t_email",nullable = false)
    private String t_email;
    @Column(name = "t_number",nullable = false)
    private String t_number;
       /*one-to-many many-to-one*/
    /*@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacher_id"
    )
    private List<Course> courses;
*/
    public Teacher() {
    }

    public Teacher(Long teacher_id, String t_name, String t_email, String t_number/*, List<Course> courses*/) {
        this.teacher_id = teacher_id;
        this.t_name = t_name;
        this.t_email = t_email;
        this.t_number = t_number;
        /*this.courses = courses;*/
    }

    public Teacher(String t_name, String t_email, String t_number/*, List<Course> courses*/) {
        this.t_name = t_name;
        this.t_email = t_email;
        this.t_number = t_number;
       /* this.courses = courses;*/
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_email() {
        return t_email;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }

    public String getT_number() {
        return t_number;
    }

    public void setT_number(String t_number) {
        this.t_number = t_number;
    }

   /* public List<Course> getCourses() {
        return courses;
    }*/

    /*public void setCourses(List<Course> courses) {
        this.courses = courses;
    }*/

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", t_name='" + t_name + '\'' +
                ", t_email='" + t_email + '\'' +
                ", t_number='" + t_number + '\'' +
                '}';
    }
}
