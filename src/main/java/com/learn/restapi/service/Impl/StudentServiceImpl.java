package com.learn.restapi.service.Impl;

import com.learn.restapi.model.Student;
import com.learn.restapi.repository.StudentRepository;
import com.learn.restapi.service.IStudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

  private StudentRepository studentRepository;

  @Autowired
  StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> getAll() {
    return studentRepository.findAll();
  }

  @Override
  public void saveStudent(Student student) {
    studentRepository.save(student);
  }
}
