package com.learn.restapi.service;

import com.learn.restapi.model.Classroom;
import com.learn.restapi.repository.ClassroomRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClassroomRepositorySpy implements ClassroomRepository {

    public boolean getOneWasCalled;
    public Map<Integer, Classroom> classrooms = new HashMap<>();
    public boolean saveWasCalled;
    public Classroom classroom;
    public boolean findOneWasCalled;

    @Override
    public List<Classroom> findAll() {
        return null;
    }

    @Override
    public List<Classroom> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Classroom> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Classroom> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Classroom classroom) {

    }

    @Override
    public void deleteAll(Iterable<? extends Classroom> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Classroom> S save(S s) {
        saveWasCalled = true;
        classroom = s;
        if (null != classroom) {
            classroom.setId(1);
        }
        return (S) classroom;
    }

    @Override
    public <S extends Classroom> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Classroom> findById(Integer integer) {
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
    public <S extends Classroom> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Classroom> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Classroom getOne(Integer integer) {
        getOneWasCalled = true;
        Classroom classroom = classrooms.get(integer);
        if (null == classroom) {
            throw new EntityNotFoundException();
        }
        return classroom;
    }

    @Override
    public <S extends Classroom> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Classroom> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Classroom> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Classroom> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Classroom> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Classroom> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Optional<Classroom> findOne(Integer id) {
        findOneWasCalled = true;
        return Optional.ofNullable(classrooms.get(id));
    }
}
