package com.learn.restapi.service.impl;

import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import com.learn.restapi.repository.StudentRepository;
import com.learn.restapi.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final ModelMapper modelMapper;

  public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
    this.studentRepository = studentRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<Student> getAll() {
    return studentRepository.findAll();
  }

  @Override
  public Student saveStudent(StudentDTO studentDTO) {
    Student student = modelMapper.map(studentDTO, Student.class);
    return studentRepository.save(student);
  }
}
