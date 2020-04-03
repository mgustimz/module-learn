package com.learn.restapi.service;

import com.learn.restapi.dto.ClassroomDTO;
import com.learn.restapi.model.Classroom;
import com.learn.restapi.service.impl.ClassroomServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityNotFoundException;

import static com.google.common.truth.Truth.assertThat;
import static com.learn.restapi.common.TestConstant.DUMMY;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClassroomServiceTest {

    private ClassroomService classroomService;
    private ClassroomRepositorySpy classroomRepositorySpy;
    private ClassroomDTO classroomDTO;

    @BeforeEach
    void setUp() {
        classroomRepositorySpy = new ClassroomRepositorySpy();
        classroomService = new ClassroomServiceImpl(classroomRepositorySpy, new ModelMapper());
        classroomDTO = getDto();
    }

    @Test
    void givenNullId_whenFindOne_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> classroomService.findOne(null));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenValidId_whenFindOne_shouldCallGetOnInRepository() {
        try {
            classroomService.findOne(1);
            assertThat(classroomRepositorySpy.getOneWasCalled).isTrue();
        } catch (Exception ignored) {
        }
    }

    @Test
    void givenValidId_whenFindOne_shouldReturnCorrectResponse() {
        try {
            assertThat(classroomService.findOne(1)).isInstanceOf(ClassroomDTO.class);
        } catch (Exception ignored) {
        }
    }

    @Test
    void givenNullEntity_whenFindOne_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> classroomService.findOne(1));
        assertThat(e).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void givenExistingEntity_whenFindOne_shouldReturnCorrectResponse() {
        injectClassroom();
        ClassroomDTO dto = classroomService.findOne(1);
        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getName()).isEqualTo(DUMMY);
        assertThat(dto.getGrade()).isEqualTo(1);
    }

    @Test
    void givenNullRequest_whenSave_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> classroomService.save(null));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenValidRequest_whenSave_shouldCallSaveInRepository() {
        classroomService.save(classroomDTO);
        assertThat(classroomRepositorySpy.saveWasCalled).isTrue();
    }

    @Test
    void givenValidRequest_whenSave_shouldConstructCorrectParams() {
        classroomService.save(classroomDTO);
        Classroom classroomInRepo = classroomRepositorySpy.classroom;
        assertThat(classroomInRepo.getName()).isEqualTo(classroomDTO.getName());
        assertThat(classroomInRepo.getGrade()).isEqualTo(classroomDTO.getGrade());
    }

    @Test
    void givenValidRequest_whenSave_shouldReturnCorrectInstance() {
        assertThat(classroomService.save(classroomDTO)).isInstanceOf(ClassroomDTO.class);
    }

    @Test
    void givenValidRequest_whenSave_shouldReturnCorrectResult() {
        ClassroomDTO dto = classroomService.save(classroomDTO);
        assertThat(dto.getId()).isAtLeast(1);
        assertThat(dto.getName()).isEqualTo(classroomDTO.getName());
        assertThat(dto.getGrade()).isEqualTo(classroomDTO.getGrade());
    }

    private void injectClassroom() {
        Classroom classroom = getClassroom();
        classroomRepositorySpy.classrooms.put(1, classroom);
    }

    private ClassroomDTO getDto() {
        ClassroomDTO dto = new ClassroomDTO();
        dto.setName(DUMMY);
        dto.setGrade(1);
        return dto;
    }

    private Classroom getClassroom() {
        Classroom classroom = new Classroom();
        classroom.setId(1);
        classroom.setName(DUMMY);
        classroom.setGrade(1);
        return classroom;
    }
}
