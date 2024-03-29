package com.fideljose.studentservice.studentservice.repository;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
