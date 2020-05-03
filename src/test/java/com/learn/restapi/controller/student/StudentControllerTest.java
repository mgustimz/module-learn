package com.learn.restapi.controller.student;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.learn.restapi.controller.StudentController;
import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.exception.InvalidRequestException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentControllerTest {

    private StudentServiceSpy serviceSpy;
    private StudentController controller;

    @BeforeEach
    void setUp() {
        serviceSpy = new StudentServiceSpy();
        controller = new StudentController(serviceSpy);
    }

    @Test
    void givenValidRequest_whenGetAll_shouldCallService() {
        controller.getAll();
        assertThat(serviceSpy.getOneWasCalled).isTrue();
    }

    @Test
    void givenValidRequest_whenGetAll_shouldReturnCorrectInstance() {
         assertThat(controller.getAll()).isInstanceOf(ArrayList.class);
    }

    @Test
    void givenNullRequest_whenAddStudent_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> controller.addStudent(null));
        assertThat(e).isInstanceOf(InvalidRequestException.class);
        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenValidRequest_whenAddStudent_shouldCallService() {
        StudentDTO studentDTO = new StudentDTO();
        controller.addStudent(studentDTO);
        assertThat(serviceSpy.addStudentWasCalled).isTrue();
    }

    @Test
    void givenValidRequest_whenAddStudent_shouldReturnCorrectInstance() {
        StudentDTO studentDTO = new StudentDTO();
        assertThat(controller.addStudent(studentDTO)).isInstanceOf(StudentDTO.class);
    }

}
