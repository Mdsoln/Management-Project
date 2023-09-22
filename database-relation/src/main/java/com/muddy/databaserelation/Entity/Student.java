package com.muddy.databaserelation.Entity;

import com.muddy.databaserelation.dto.GuardianDto;
import jakarta.persistence.*;

@Entity
@Table(
        name = "students",
        uniqueConstraints = @UniqueConstraint(
                name = "email",columnNames = "email"
        )
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long studentId;
    @Column(name = "fname",nullable = false)
    private String studentFname;
    @Column(name = "lname",nullable = false)
    private String studentLname;
    @Column(name = "email",nullable = false)
    private String studentEmail;
    @Embedded
    private Guardian guardian;


    public Student() {
    }

    public Student(Long studentId, String studentFname, String studentLname, String studentEmail, Guardian guardian) {
        this.studentId = studentId;
        this.studentFname = studentFname;
        this.studentLname = studentLname;
        this.studentEmail = studentEmail;
        this.guardian = guardian;
    }

    public Student(String studentFname, String studentLname, String studentEmail, Guardian guardian) {
        this.studentFname = studentFname;
        this.studentLname = studentLname;
        this.studentEmail = studentEmail;
        this.guardian = guardian;
    }

    public Student(String studentFname, String studentLname, String studentEmail, GuardianDto guardianDto) {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentFname() {
        return studentFname;
    }

    public void setStudentFname(String studentFname) {
        this.studentFname = studentFname;
    }

    public String getStudentLname() {
        return studentLname;
    }

    public void setStudentLname(String studentLname) {
        this.studentLname = studentLname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentFname='" + studentFname + '\'' +
                ", studentLname='" + studentLname + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", guardian=" + guardian +
                '}';
    }
}
