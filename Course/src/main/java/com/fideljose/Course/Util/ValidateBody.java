package com.fideljose.Course.Util;

import com.fideljose.Course.entity.model.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ValidateBody {

    public static ResponseEntity<?> validateCourse(Course course, BindingResult validResult){
            Map<String, String> errors = new HashMap<>();
            validResult.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), "The field " + err.getField() + " " + err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
    }
}
