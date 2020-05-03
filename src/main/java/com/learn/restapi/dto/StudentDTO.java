package com.learn.restapi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class StudentDTO {

    private int id;
    private String name;
    private int age;
}   
