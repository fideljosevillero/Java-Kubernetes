package com.fideljose.studentservice.studentservice.service;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import com.fideljose.studentservice.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Optional<Student> saveStudent() {
        return Optional.empty();
    }

    @Override
    public Optional<Student> findByIdStudent() {
        return Optional.empty();
    }

    @Override
    public void deleteStudent() {

    }
}
