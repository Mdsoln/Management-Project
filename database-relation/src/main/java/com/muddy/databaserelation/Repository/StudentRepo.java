package com.muddy.databaserelation.Repository;

import com.muddy.databaserelation.Entity.Student;
import com.muddy.databaserelation.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
     Student findByStudentLname(String name);

     Student findByStudentEmail(String email);


}
