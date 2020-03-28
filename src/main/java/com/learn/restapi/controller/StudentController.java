package com.learn.restapi.controller;

import com.learn.restapi.model.Student;
import com.learn.restapi.repository.StudentRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

  private StudentRepository studentRepository;

  @Autowired
  StudentController(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @GetMapping("/")
  public List<Student> getAll() {
    return studentRepository.findAll();
  }

  @PostMapping("/")
  public Student addStudent(@Valid @RequestBody Student student) {
    return studentRepository.save(student);
  }

}
