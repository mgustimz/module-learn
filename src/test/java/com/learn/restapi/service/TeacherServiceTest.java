package com.learn.restapi.service;

import com.learn.restapi.dto.TeacherDTO;
import com.learn.restapi.model.Teacher;
import com.learn.restapi.service.impl.TeacherServiceImpl;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static com.google.common.truth.Truth.assertThat;
import static com.learn.restapi.common.TestConstant.DUMMY;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeacherServiceTest {

    private TeacherService teacherService;
    private TeacherRepositorySpy teacherRepositorySpy;
    private TeacherDTO teacherDTO;

    @BeforeEach
    void setUp() {
        teacherRepositorySpy = new TeacherRepositorySpy();
        teacherService = new TeacherServiceImpl(teacherRepositorySpy, new ModelMapper());
        teacherDTO = getDto();
    }

    @Test
    void givenNullId_whenFindOne_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> teacherService.findOne(null));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenValidId_whenFindOne_shouldCallGetOneInRepository() {
        try {
            teacherService.findOne(1);
            assertThat(teacherRepositorySpy.getOneWasCalled).isTrue();
        } catch (Exception ignored) {
        }
    }

    @Test
    void givenValidId_whenFindOne_shouldReturnCorrectResponse() {
        try {
            assertThat(teacherService.findOne(1)).isInstanceOf(TeacherDTO.class);
        } catch (Exception ignored) {
        }
    }

    @Test
    void givenNullEntity_whenFindOne_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> teacherService.findOne(1));
        assertThat(e).isInstanceOf(EntityNotFoundException.class);
    }

    @Test
    void givenExistingEntity_whenFindOne_shouldReturnCorrectResponse() {
        injectTeacher();
        TeacherDTO dto = teacherService.findOne(1);
        assertThat(dto.getId()).isEqualTo(1);
        assertThat(dto.getName()).isEqualTo(DUMMY);
        assertThat(dto.getAge()).isEqualTo(23);
        assertThat(dto.getFieldOfStudy()).isEqualTo(DUMMY);
    }

    @Test
    void givenNullRequest_whenSave_shouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> teacherService.save(null));
        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenValidRequest_whenSave_shouldCallSaveInRepository() {
        teacherService.save(teacherDTO);
        assertThat(teacherRepositorySpy.saveWasCalled).isTrue();
    }

    @Test
    void givenValidRequest_whenSave_shouldConstructCorrectParams() {
        teacherService.save(teacherDTO);
        Teacher teacherInRepo = teacherRepositorySpy.teacher;
        assertThat(teacherInRepo.getName()).isEqualTo(teacherDTO.getName());
        assertThat(teacherInRepo.getAge()).isEqualTo(teacherDTO.getAge());
        assertThat(teacherInRepo.getFieldOfStudy()).isEqualTo(teacherDTO.getFieldOfStudy());
    }

    @Test
    void givenValidRequest_whenSave_shouldReturnCorrectInstance() {
        assertThat(teacherService.save(teacherDTO)).isInstanceOf(TeacherDTO.class);
    }

    @Test
    void givenValidRequest_whenSave_shouldReturnCorrectResult() {
        TeacherDTO dto = teacherService.save(teacherDTO);
        assertThat(dto.getId()).isAtLeast(1);
        assertThat(dto.getName()).isEqualTo(teacherDTO.getName());
        assertThat(dto.getAge()).isEqualTo(teacherDTO.getAge());
        assertThat(dto.getFieldOfStudy()).isEqualTo(teacherDTO.getFieldOfStudy());
    }

    private void injectTeacher() {
        Teacher classroom = getTeacher();
        teacherRepositorySpy.teachers.put(1, classroom);
    }

    private Teacher getTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName(DUMMY);
        teacher.setAge(23);
        teacher.setFieldOfStudy(DUMMY);
        return teacher;
    }

    private TeacherDTO getDto() {
        TeacherDTO dto = new TeacherDTO();
        dto.setName(DUMMY);
        dto.setAge(23);
        dto.setFieldOfStudy(DUMMY);
        return dto;
    }

}
