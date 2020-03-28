package com.learn.restapi.controller;

import com.learn.restapi.model.Student;
import com.learn.restapi.service.IStudentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

  private IStudentService iStudentService;

  @Autowired
  StudentController(IStudentService iStudentService) {
    this.iStudentService = iStudentService;
  }

  @GetMapping("/")
  public List<Student> getAll() {
    return iStudentService.getAll();
  }

  @PostMapping("/")
  public Student addStudent(@Valid @RequestBody Student student) {
    return iStudentService.saveStudent(student);
  }

  @GetMapping(value = "/ok")
  public ResponseEntity<String> getCheckOk() {
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

}
