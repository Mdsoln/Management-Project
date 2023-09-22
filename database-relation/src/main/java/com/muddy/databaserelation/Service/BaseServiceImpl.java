package com.muddy.databaserelation.Service;

import com.muddy.databaserelation.Entity.*;
import com.muddy.databaserelation.Exception.CourseCreationException;
import com.muddy.databaserelation.Exception.StudentNotFoundException;
import com.muddy.databaserelation.Repository.CourseRepo;
import com.muddy.databaserelation.Repository.MaterialRepo;
import com.muddy.databaserelation.Repository.StudentRepo;
import com.muddy.databaserelation.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseServiceInterface{
     @Autowired
     private StudentRepo studentRepo;
     @Autowired
     private CourseRepo courseRepo;
     @Autowired
     private MaterialRepo materialRepo;
    @Override
    public void addNewStudent(Student student) {

        Guardian guardian = new Guardian();
        guardian.setGuardianName(student.getGuardian().getGuardianName());
        guardian.setGuardianEmail(student.getGuardian().getGuardianEmail());
        guardian.setGuardianNumber(student.getGuardian().getGuardianNumber());

        Student student1 = new Student();
        student1.setStudentFname(student.getStudentFname());
        student1.setStudentLname(student.getStudentLname());
        student1.setStudentEmail(student1.getStudentEmail());
        student1.setGuardian(guardian);

        studentRepo.save(student1);
    }

    @Override
    public void addNewCourse(Course course, String studentEmail) {
        try {
            Student student = studentRepo.findByStudentEmail(studentEmail);
            if (student != null){
                Course course1 = new Course();
                course1.setCourseTitle(course.getCourseTitle());
                course1.setCredit(course.getCredit());
                course1.addStudent(student);
                courseRepo.save(course1);
            }
            else {
               throw new StudentNotFoundException("Student with email: "+" not found");
            }
        }catch (Exception e){
           throw new CourseCreationException("Failed to create course!!! "+ e.getMessage(),e);
        }
    }

    @Override
    public void addCourseWithMaterials(Course course,CourseMaterials materials) {
        try{
            Course courses = new Course();
            course.setCourseTitle(course.getCourseTitle());
            course.setCredit(course.getCredit());

            CourseMaterials courseMaterials = new CourseMaterials();
            courseMaterials.setUrl(materials.getUrl());
            courseMaterials.setCourse(courses);
            materialRepo.save(courseMaterials);
        }catch (Exception exception){
            throw new CourseCreationException("Failed to save the courses: "+exception.getMessage(),exception);
        }
    }

    @Override
    public Student findByStudentEmail(String email) {
        return studentRepo.findByStudentEmail(email);
    }

    @Override
    public Student saveStudents(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getStudentFname(),studentDto.getStudentLname(),
                studentDto.getStudentEmail(),studentDto.getGuardianDto()
        );
        return studentRepo.save(student);
    }
}
