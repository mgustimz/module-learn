package com.learn.restapi.service.impl;

import com.learn.restapi.dto.ClassroomDTO;
import com.learn.restapi.model.Classroom;
import com.learn.restapi.repository.ClassroomRepository;
import com.learn.restapi.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ModelMapper modelMapper;

    @Override
    public ClassroomDTO findOne(Integer id) {
        validateRequest(id);
        Classroom classroom = classroomRepository.findOne(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Classroom with Id [%s] doesn't exist", id))
        );
        return modelMapper.map(classroom, ClassroomDTO.class);
    }

    @Override
    public ClassroomDTO save(ClassroomDTO dto) {
        validateRequest(dto);
        Classroom classroom = modelMapper.map(dto, Classroom.class);
        classroomRepository.save(classroom);
        return modelMapper.map(classroom, ClassroomDTO.class);
    }

    private void validateRequest(Object request) {
        if (null == request) {
            throw new IllegalArgumentException("Request cannot be null");
        }
    }
}
