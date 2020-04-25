package com.lipeng.student.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "stu_student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String userface;
    private String subject;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Temporal(TemporalType.DATE)
    private Date created;
    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "classId",referencedColumnName = "id",insertable = false,updatable = false)
    private Clazz className;

}
