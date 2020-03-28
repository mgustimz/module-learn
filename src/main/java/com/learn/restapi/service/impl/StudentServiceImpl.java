package com.learn.restapi.service.impl;

import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import com.learn.restapi.repository.StudentRepository;
import com.learn.restapi.service.IStudentService;
import java.util.List;
import javax.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

  private StudentRepository studentRepository;

  @Autowired
  StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Resource(name = "modelMapper")
  private ModelMapper modelMapper;

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
