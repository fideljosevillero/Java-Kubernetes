package com.fideljose.studentservice.studentservice.service;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student>  findAllStudents();
    Student saveStudent(Student student);
    Optional<Student> findByIdStudent(Long id);
    void deleteStudent();
    List<Student> getListStudentByIds(Iterable<Long> ids);
}
