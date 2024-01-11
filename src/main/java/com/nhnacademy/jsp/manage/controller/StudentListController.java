package com.nhnacademy.jsp.manage.controller;

import com.nhnacademy.jsp.manage.RequestMapping;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@RequestMapping(value = "/student/list.do", method = RequestMapping.Method.GET)

public class StudentListController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList",studentList);
        return "/student/list.jsp";
    }
}
