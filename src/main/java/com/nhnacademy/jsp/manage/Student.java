package com.nhnacademy.jsp.manage;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private Gender gender;
    private int age;
    private LocalDateTime createAt;

    public Student(String id,String name,Gender gender,int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        createAt = LocalDateTime.now();
    }


}
