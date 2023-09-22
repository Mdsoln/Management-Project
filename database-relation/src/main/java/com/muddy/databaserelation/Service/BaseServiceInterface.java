package com.muddy.databaserelation.Service;

import com.muddy.databaserelation.Entity.Course;
import com.muddy.databaserelation.Entity.CourseMaterials;
import com.muddy.databaserelation.Entity.Student;
import com.muddy.databaserelation.dto.StudentDto;

public interface BaseServiceInterface {

    void addNewStudent(Student student);

    void addNewCourse(Course course,String email);

    void addCourseWithMaterials(Course course,CourseMaterials materials);

    Student findByStudentEmail(String email);
    Student saveStudents(StudentDto studentDto);
}
