package com.learn.restapi.controller;

import com.learn.restapi.dto.ClassroomDTO;
import com.learn.restapi.exception.InvalidRequestException;
import com.learn.restapi.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;

    @GetMapping
    public ClassroomDTO findOne(@RequestParam Integer id) {
        validateRequest(id);
        return classroomService.findOne(id);
    }

    private void validateRequest(Object request) {
        if (null == request) {
            throw new InvalidRequestException("Request cannot be null");
        }
    }
}
