package com.learn.restapi.controller.student;

import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import com.learn.restapi.service.StudentService;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceSpy implements StudentService {

    boolean addStudentWasCalled;
    boolean getOneWasCalled;

    @Override
    public List<Student> getAll() {
        getOneWasCalled = true;
        return new ArrayList<>();
    }

    @Override
    public StudentDTO saveStudent(StudentDTO student) {
        addStudentWasCalled = true;
        return student;
    }
}
