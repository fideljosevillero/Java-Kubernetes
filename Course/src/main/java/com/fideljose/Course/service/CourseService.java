package com.fideljose.Course.service;

import com.fideljose.Course.entity.StudentDto;
import com.fideljose.Course.entity.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course saveCourse(Course course);
    List<Course> listCourse();

    Optional<StudentDto> assignStudentToCourse(StudentDto studentDto, Long courseId);
    Optional<StudentDto> removeStudentToCourse(StudentDto studentDto, Long courseId);
    Optional<StudentDto> createNewStudentToCourse(StudentDto studentDto, Long courseId);


}
