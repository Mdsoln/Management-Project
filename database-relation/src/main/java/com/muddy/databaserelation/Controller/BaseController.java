package com.muddy.databaserelation.Controller;

import com.muddy.databaserelation.Entity.Course;
import com.muddy.databaserelation.Entity.CourseMaterials;
import com.muddy.databaserelation.Entity.Student;
import com.muddy.databaserelation.Service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1")
public class BaseController {
    @Autowired
    private BaseServiceImpl service;

    @PostMapping("/addStudent")
    public void addStudentDetails(@RequestBody @Valid Student student){
        service.addNewStudent(student);
    }

    @PostMapping("/addCourse")
    public void addCourseDetails(@RequestBody @Valid Course course,String studentEmail){
        service.addNewCourse(course,studentEmail);
    }

    @PostMapping("/courseWithMaterials")
    public void courseWithMaterials(@RequestBody Course course, CourseMaterials materials){
        service.addCourseWithMaterials(course,materials);
    }
}
