package com.learn.restapi.service;

import com.learn.restapi.dto.TeacherDTO;

public interface TeacherService {

    TeacherDTO findOne(Integer id);

    TeacherDTO save(TeacherDTO dto);
}
