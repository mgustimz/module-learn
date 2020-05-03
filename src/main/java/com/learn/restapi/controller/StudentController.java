package com.learn.restapi.controller;

import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.exception.InvalidRequestException;
import com.learn.restapi.model.Student;
import com.learn.restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO student) {
        validateRequest(student);
        return studentService.saveStudent(student);
    }

    private void validateRequest(StudentDTO student) {
        if (null == student) {
            throw new InvalidRequestException("Request cannot be null");
        }
    }
}
