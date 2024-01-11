package com.nhnacademy.jsp.manage.repository;

import com.nhnacademy.jsp.manage.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);

    void update(Student student);

    void deleteById(String id);

    Student getStudentById(String id);
    //학생-리스트
    List<Student> getStudents();
    //학생-아이디 존재여부
    boolean existById(String id);
    public int getSize();


}

