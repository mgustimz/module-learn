package com.learn.restapi.controller.classroom;

import com.learn.restapi.dto.ClassroomDTO;
import com.learn.restapi.service.ClassroomService;

public class ClassroomServiceSpy implements ClassroomService {

    boolean findOneWasCalled;
    Integer id;

    @Override
    public ClassroomDTO findOne(Integer id) {
        findOneWasCalled = true;
        this.id = id;
        return new ClassroomDTO();
    }

    @Override
    public ClassroomDTO save(ClassroomDTO dto) {
        return null;
    }
}
