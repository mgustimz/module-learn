package com.learn.restapi.service;

import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import java.util.List;

public interface IStudentService {

  List<Student> getAll();
  Student saveStudent(StudentDTO student);

}
