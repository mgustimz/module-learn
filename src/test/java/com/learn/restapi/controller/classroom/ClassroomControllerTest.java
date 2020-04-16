package com.learn.restapi.controller.classroom;

import com.learn.restapi.controller.ClassroomController;
import com.learn.restapi.dto.ClassroomDTO;
import com.learn.restapi.exception.InvalidRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.google.common.truth.Truth.assertThat;

class ClassroomControllerTest {

    private ClassroomServiceSpy serviceSpy;
    private ClassroomController controller;

    @BeforeEach
    void setUp() {
        serviceSpy = new ClassroomServiceSpy();
        controller = new ClassroomController(serviceSpy);
    }

    @Test
    void givenNullRequest_whenFindOne_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> controller.findOne(null));
        assertThat(e).isInstanceOf(InvalidRequestException.class);
        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenValidRequest_whenFindOne_shouldCallService() {
        controller.findOne(1);
        assertThat(serviceSpy.findOneWasCalled).isTrue();
    }

    @Test
    void givenValidRequest_whenFindOne_shouldGiveCorrectParamInService() {
        controller.findOne(1);
        assertThat(serviceSpy.id).isEqualTo(1);
    }

    @Test
    void givenValidRequest_whenFindOne_shouldReturnCorrectInstance() {
        assertThat(controller.findOne(1)).isInstanceOf(ClassroomDTO.class);
    }
}
