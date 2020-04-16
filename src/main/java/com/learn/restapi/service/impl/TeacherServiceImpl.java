package com.learn.restapi.service.impl;

import com.learn.restapi.dto.TeacherDTO;
import com.learn.restapi.model.Teacher;
import com.learn.restapi.repository.TeacherRepository;
import com.learn.restapi.service.TeacherService;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;

    @Override
    public TeacherDTO findOne(Integer id) {
        validateRequest(id);
        Teacher teacher = teacherRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Teacher with Id [%s] doesn't exist", id)
                )
        );
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    @Override
    public TeacherDTO save(TeacherDTO dto) {
        validateRequest(dto);
        Teacher teacher = modelMapper.map(dto, Teacher.class);
        teacherRepository.save(teacher);
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    private void validateRequest(Object id) {
        if (null == id) {
            throw new IllegalArgumentException("Request cannot be null");
        }
    }
}
