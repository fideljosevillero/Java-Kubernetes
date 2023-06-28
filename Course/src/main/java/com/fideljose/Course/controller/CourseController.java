package com.fideljose.Course.controller;

import com.fideljose.Course.Util.ValidateBody;
import com.fideljose.Course.entity.StudentDto;
import com.fideljose.Course.entity.model.Course;
import com.fideljose.Course.service.CourseService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/")
    public ResponseEntity<?> getCourses(){
        return ResponseEntity.ok(service.listCourse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id){
        //return ResponseEntity.ok(service.getCourseById(id));
        Optional<Course> course = service.getCourseById(id);
        if(course.isPresent()){
            if(!course.get().getCourseStudentList().isEmpty()){
                Course courseObj = course.get();
                List<Long> ids = courseObj.getCourseStudentList().stream().map(std -> std.getIdStudent()).collect(Collectors.toList());
                List<StudentDto> students = service.getStudentsListByIds(ids);
                courseObj.setStudents(students);
                return ResponseEntity.status(HttpStatus.OK).body(courseObj);
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> saveCourse(@Valid @RequestBody Course course, BindingResult validResult){
        if(validResult.hasErrors()){
            return ValidateBody.validateCourse(course, validResult);
        }
        return ResponseEntity.ok().body(service.saveCourse(course));
    }

    @PutMapping("/assign-student/{courseId}")
    public ResponseEntity<?> assingStudentToCourse(@PathVariable Long courseId, @RequestBody StudentDto studentDto){
        Optional<StudentDto> student ;
        try{
            student =  service.assignStudentToCourse(studentDto, courseId);
        }catch(FeignException err){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error Message ", "Comunications Error"));
        }
        if(student.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create-student/{courseId}")
    public ResponseEntity<?> createStudentToCourse(@PathVariable Long courseId, @RequestBody StudentDto studentDto){
        Optional<StudentDto> student ;
        try{
            student =  service.createNewStudentToCourse(studentDto, courseId);
        }catch(FeignException err){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error Message ", "Comunications Error"));
        }
        if(student.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-student/{courseId}")
    public ResponseEntity<?> deleteStudentToCourse(@PathVariable Long courseId, @RequestBody StudentDto studentDto){
        Optional<StudentDto> student ;
        try{
            student =  service.removeStudentToCourse(studentDto, courseId);
        }catch(FeignException err){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error Message ", "Comunications Error"));
        }
        if(student.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }
        return ResponseEntity.notFound().build();
    }


}
