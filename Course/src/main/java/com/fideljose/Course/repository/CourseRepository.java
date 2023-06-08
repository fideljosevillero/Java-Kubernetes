package com.fideljose.Course.repository;

import com.fideljose.Course.entity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
