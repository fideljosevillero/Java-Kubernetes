package com.fideljose.Course.adapter;

import com.fideljose.Course.entity.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@FeignClient(name = "student-service", url = "localhost:8001")
public interface RestClient {

    @PostMapping("/")
    StudentDto createStudent(StudentDto studentDto);

    @GetMapping("/")
    StudentDto listStudent();

    @GetMapping("/{id}")
    Optional<StudentDto> studentFindById(@PathVariable Long id);
}
