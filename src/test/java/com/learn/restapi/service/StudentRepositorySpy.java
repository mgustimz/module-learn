package com.learn.restapi.service;

import static com.learn.restapi.common.TestConstant.DUMMY;

import com.learn.restapi.common.TestConstant;
import com.learn.restapi.dto.StudentDTO;
import com.learn.restapi.model.Student;
import com.learn.restapi.repository.StudentRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class StudentRepositorySpy implements StudentRepository {

    public boolean findAllWasCalled;
    public boolean saveWasCalled;
    public Student student;
    public Map<StudentDTO, Student> students = new HashMap<>();

    @Override
    public List<Student> findAll() {
        findAllWasCalled = true;
        Student st = new Student();
        st.setId(1);
        st.setName("gusti");
        st.setAge(23);
        List<Student> student = new ArrayList<>();
        student.add(st);
        return student;
    }

    @Override
    public List<Student> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Student> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void deleteAll(Iterable<? extends Student> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Student> S save(S s) {
        saveWasCalled = true;
        student = s;
        if (null != student) {
            student.setId(1);
        }
        return (S) student;
    }

    @Override
    public <S extends Student> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Student> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Student> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Student getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Student> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Student> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Student> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Student> boolean exists(Example<S> example) {
        return false;
    }
}
