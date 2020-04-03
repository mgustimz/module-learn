package com.learn.restapi.repository;

import com.learn.restapi.model.Student;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.truth.Truth.assertThat;
import static com.learn.restapi.common.TestConstant.DUMMY;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class StudentRepositoryIntegrationTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void givenStudent_whenSave_shouldAddInRepository() {
        Student student = new Student();
        studentRepository.save(student);
        assertThat(studentRepository.count()).isEqualTo(1);
    }

    @Test
    void givenStudent_whenSave_shouldReturnCorrectResult() {
        injectStudent();
        List<Student> student = studentRepository.findAll();
        assertThat(student).isNotNull();
        assertThat(student.get(0).getName()).isEqualTo(DUMMY);
        assertThat(student.get(0).getAge()).isEqualTo(23);
    }

    private void injectStudent() {
        Student student = getStudent();
        studentRepository.save(student);
    }

    private Student getStudent() {
        Student student = new Student();
        student.setName(DUMMY);
        student.setAge(23);
        return student;
    }

}
