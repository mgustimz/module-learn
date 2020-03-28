package com.learn.restapi.service;

import com.learn.restapi.dto.ClassroomDTO;

public interface ClassroomService {

    ClassroomDTO findOne(Integer id);

    ClassroomDTO save(ClassroomDTO dto);
}
