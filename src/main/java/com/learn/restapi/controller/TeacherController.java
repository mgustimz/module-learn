package com.learn.restapi.controller;

import com.learn.restapi.dto.TeacherDTO;
import com.learn.restapi.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public TeacherDTO findOne(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.findOne(teacherDTO.getId());
    }

    @PostMapping
    public TeacherDTO save(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.save(teacherDTO);
    }

}
