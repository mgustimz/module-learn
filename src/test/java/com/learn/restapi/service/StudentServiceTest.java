package com.learn.restapi.service;

import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import com.learn.restapi.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static com.google.common.truth.Truth.assertThat;
import static com.learn.restapi.common.TestConstant.DUMMY;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentServiceTest {


    private StudentService studentService;
    private StudentRepositorySpy studentRepositorySpy;
    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentRepositorySpy = new StudentRepositorySpy();
        studentService = new StudentServiceImpl(studentRepositorySpy, new ModelMapper());
        studentDTO = getDto();
    }

    @Test
    void givenValidRequest_whenFindAll_shouldCallFindAllInRepository() {
        studentService.getAll();
        assertThat(studentRepositorySpy.findAllWasCalled).isTrue();
    }

    @Test
    void givenNullRequest_whenSave_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> studentService.saveStudent(null));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenValidRequest_whenSave_shouldCallSaveInRepository() {
        studentService.saveStudent(studentDTO);
        assertThat(studentRepositorySpy.saveWasCalled).isTrue();
    }

    @Test
    void givenValidRequest_whenSave_shouldConstructCorrectParams() {
        studentService.saveStudent(studentDTO);
        Student studentInRepo = studentRepositorySpy.student;
        assertThat(studentInRepo.getName()).isEqualTo(studentDTO.getName());
        assertThat(studentInRepo.getAge()).isEqualTo(studentDTO.getAge());
    }

    @Test
    void givenValidRequest_whenSave_shouldReturnCorrectInstance() {
        assertThat(studentService.saveStudent(studentDTO)).isInstanceOf(StudentDTO.class);
    }

    @Test
    void givenValidRequest_whenSave_shouldReturnCorrectResult() {
        StudentDTO studentDTO = studentService.saveStudent(this.studentDTO);
        assertThat(studentDTO.getId()).isAtLeast(1);
        assertThat(studentDTO.getName()).isEqualTo(this.studentDTO.getName());
        assertThat(studentDTO.getAge()).isEqualTo(this.studentDTO.getAge());
    }

    private StudentDTO getDto() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1);
        studentDTO.setName(DUMMY);
        studentDTO.setAge(23);
        return studentDTO;
    }

}
