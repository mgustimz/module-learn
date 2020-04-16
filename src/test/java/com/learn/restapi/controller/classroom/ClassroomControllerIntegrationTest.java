package com.learn.restapi.controller.classroom;

import com.learn.restapi.controller.ClassroomController;
import com.learn.restapi.dto.ClassroomDTO;
import com.learn.restapi.service.ClassroomService;
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

import static com.learn.restapi.common.TestConstant.DUMMY;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClassroomController.class)
class ClassroomControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassroomService classroomService;

    @BeforeEach
    void setUp() {
        ClassroomDTO classroom = getClassroom();
        Mockito.when(classroomService.findOne(1)).thenReturn(classroom);
    }

    @Test
    void givenValidRequest_whenFindOne_shouldReturnCorrectResult() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/classroom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is(DUMMY)))
                .andExpect(jsonPath("$.grade", is(1))
                );
    }

    private ClassroomDTO getClassroom() {
        ClassroomDTO classroom = new ClassroomDTO();
        classroom.setId(1);
        classroom.setName(DUMMY);
        classroom.setGrade(1);
        return classroom;
    }
}
