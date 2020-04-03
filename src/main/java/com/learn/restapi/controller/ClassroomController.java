package com.learn.restapi.controller;

import com.learn.restapi.dto.ClassroomDTO;
import com.learn.restapi.service.ClassroomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    private ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public ClassroomDTO findOne(@RequestBody ClassroomDTO classroomDTO) {
        return classroomService.findOne(classroomDTO.getId());
    }

    @PostMapping
    public ClassroomDTO save(@RequestBody ClassroomDTO classroomDTO) {
        return classroomService.save(classroomDTO);
    }

}
