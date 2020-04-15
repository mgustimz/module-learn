package com.learn.restapi.repository;

import com.learn.restapi.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    Optional<Classroom> findOne(Integer id);
}
