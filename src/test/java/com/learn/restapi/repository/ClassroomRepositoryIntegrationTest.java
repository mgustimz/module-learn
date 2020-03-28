package com.learn.restapi.repository;

import com.learn.restapi.model.Classroom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.truth.Truth.assertThat;
import static com.learn.restapi.common.TestConstant.DUMMY;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ClassroomRepositoryIntegrationTest {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Test
    void givenClassroom_whenSave_shouldAddInRepository() {
        Classroom classroom = new Classroom();
        classroomRepository.save(classroom);
        assertThat(classroomRepository.count()).isEqualTo(1);
    }

    @Test
    void givenClassroom_whenFind_shouldReturnCorrectResult() {
        injectClassroom();
        Classroom classroom = classroomRepository.getOne(1);
        assertThat(classroom).isNotNull();
        assertThat(classroom.getName()).isEqualTo(DUMMY);
        assertThat(classroom.getGrade()).isEqualTo(1);
    }

    private void injectClassroom() {
        Classroom classroom = getClassroom();
        classroomRepository.save(classroom);
    }

    private Classroom getClassroom() {
        Classroom classroom = new Classroom();
        classroom.setName(DUMMY);
        classroom.setGrade(1);
        return classroom;
    }
}
