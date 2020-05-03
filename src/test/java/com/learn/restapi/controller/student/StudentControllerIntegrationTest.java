package com.learn.restapi.controller.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.restapi.controller.StudentController;
import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import com.learn.restapi.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Collections;
import java.util.List;

import static com.learn.restapi.common.TestConstant.DUMMY;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        List<Student> student = getStudent();
        StudentDTO studentDTO = getStudentDTO();
        Mockito.when(studentService.getAll()).thenReturn(student);
        Mockito.when(studentService.saveStudent(studentDTO)).thenReturn(studentDTO);
    }

    @Test
    void givenValidRequest_whenGetAll_shouldReturnCorrectResult() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/student")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is(DUMMY)))
                .andExpect(jsonPath("$[0].age", is(20))
                );
    }

    @Test
    void givenValidRequest_whenAddStudent_shouldReturnCorrectResult() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(DUMMY);
        studentDTO.setAge(20);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(studentDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(0)))
                .andExpect(jsonPath("$.name", is(DUMMY)))
                .andExpect(jsonPath("$.age", is(20)))
                .andReturn();
    }

    private List<Student> getStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName(DUMMY);
        student.setAge(20);
        return Collections.singletonList(student);
    }

    private StudentDTO getStudentDTO() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(DUMMY);
        studentDTO.setAge(20);
        return studentDTO;
    }

}
