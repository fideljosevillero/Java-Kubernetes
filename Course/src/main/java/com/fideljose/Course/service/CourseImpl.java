package com.fideljose.Course.service;

import com.fideljose.Course.adapter.RestClient;
import com.fideljose.Course.entity.StudentDto;
import com.fideljose.Course.entity.model.Course;
import com.fideljose.Course.entity.model.CourseStudent;
import com.fideljose.Course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImpl implements CourseService{

    @Autowired
    private CourseRepository repository;

    @Autowired
    private RestClient restClient;

    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> listCourse() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Optional<StudentDto> assignStudentToCourse(StudentDto studentDto, Long courseId) {
        Optional<Course> course = getCourseExist(courseId);
        Optional<StudentDto> student = getStudentExist(studentDto.getId());
        if(course.isPresent()
                && student.isPresent()){

            CourseStudent courseStudent = CourseStudent.builder()
                    .idStudent(student.get().getId())
                    .build();

            course.get().assignStudentToCourse(courseStudent);
            repository.save(course.get());
            return student;
        }
        return Optional.empty();
    }


    @Override
    @Transactional
    public Optional<StudentDto> createNewStudentToCourse(StudentDto studentDto, Long courseId) {
        Optional<Course> course = getCourseExist(courseId);
        if(course.isPresent()){
            StudentDto newStudent = restClient.createStudent(studentDto);
            CourseStudent courseStudent = CourseStudent.builder()
                    .idStudent(newStudent.getId())
                    .build();
            course.get().assignStudentToCourse(courseStudent);
            return Optional.of(newStudent);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<StudentDto> removeStudentToCourse(StudentDto studentDto, Long courseId) {
        Optional<Course> course = getCourseExist(courseId);
        Optional<StudentDto> student = getStudentExist(studentDto.getId());
        if(course.isPresent() && student.isPresent()){
            CourseStudent courseStudent = CourseStudent.builder()
                    .idStudent(student.get().getId())
                    .build();
            course.get().removeStudentToCourse(courseStudent);
            repository.delete(course.get());
            return student;
        }
        return Optional.empty();
    }

    private Optional<Course> getCourseExist(Long courseId) {
        return repository.findById(courseId);
    }

    private Optional<StudentDto> getStudentExist(Long studentId) {
        return restClient.studentFindById(studentId);
    }

}
