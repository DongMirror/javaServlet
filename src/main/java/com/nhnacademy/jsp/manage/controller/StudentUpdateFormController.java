package com.nhnacademy.jsp.manage.controller;

import com.nhnacademy.jsp.manage.RequestMapping;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
@RequestMapping(value = "/student/update.do", method = RequestMapping.Method.GET)

public class StudentUpdateFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        if (Objects.nonNull(studentRepository)) {
            String id = req.getParameter("id");
            Student student = studentRepository.getStudentById(id);
            req.setAttribute("student", student);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/student/register.jsp");
//            dispatcher.forward(req, resp);
        }
        return "/student/register.jsp";
    }
}
