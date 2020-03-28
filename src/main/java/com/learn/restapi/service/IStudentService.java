package com.learn.restapi.service;

import com.learn.restapi.model.Student;
import java.util.List;

public interface IStudentService {

  List<Student> getAll();
  Student saveStudent(Student student);

}
