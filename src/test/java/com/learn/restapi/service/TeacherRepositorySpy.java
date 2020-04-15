package com.learn.restapi.service;

import com.learn.restapi.model.Teacher;
import com.learn.restapi.repository.TeacherRepository;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class TeacherRepositorySpy implements TeacherRepository {

    public boolean getOneWasCalled;
    public Map<Integer, Teacher> teachers = new HashMap<>();
    public Teacher teacher;
    public boolean saveWasCalled;

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public List<Teacher> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Teacher> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Teacher teacher) {

    }

    @Override
    public void deleteAll(Iterable<? extends Teacher> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Teacher> S save(S s) {
        saveWasCalled = true;
        teacher = s;
        if (null != teacher) {
            teacher.setId(1);
        }
        return (S) teacher;
    }

    @Override
    public <S extends Teacher> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Teacher> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Teacher> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Teacher> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Teacher getOne(Integer integer) {
        getOneWasCalled = true;
        Teacher classroom = teachers.get(integer);
        if (null == classroom) {
            throw new EntityNotFoundException();
        }
        return classroom;
    }

    @Override
    public <S extends Teacher> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Teacher> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Teacher> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Teacher> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Teacher> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Teacher> boolean exists(Example<S> example) {
        return false;
    }
}
