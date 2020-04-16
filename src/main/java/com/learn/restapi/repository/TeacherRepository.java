package com.learn.restapi.repository;

import com.learn.restapi.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findById(Integer id);
}
