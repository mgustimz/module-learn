package com.learn.restapi.service;

import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import java.util.List;

public interface StudentService {

    List<Student> getAll();

    StudentDTO saveStudent(StudentDTO student);
}
