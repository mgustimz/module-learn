package com.learn.restapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Integer age;
}
