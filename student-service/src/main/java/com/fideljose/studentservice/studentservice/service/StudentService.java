package com.fideljose.studentservice.studentservice.service;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student>  findAllStudents();
    Optional<Student> saveStudent();
    Optional<Student> findByIdStudent();
    void deleteStudent();
}
