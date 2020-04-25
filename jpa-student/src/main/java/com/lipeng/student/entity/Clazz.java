package com.lipeng.student.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stu_clazz")
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
