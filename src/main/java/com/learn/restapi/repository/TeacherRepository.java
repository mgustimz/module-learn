package com.learn.restapi.repository;

import com.learn.restapi.model.Classroom;
import com.learn.restapi.model.Teacher;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findOne(Integer id);
}
