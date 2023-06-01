package com.fideljose.studentservice.studentservice.repository;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Long> {
}
