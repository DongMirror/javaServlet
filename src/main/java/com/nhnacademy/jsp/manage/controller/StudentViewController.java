package com.nhnacademy.jsp.manage.controller;

import com.nhnacademy.jsp.manage.RequestMapping;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
@RequestMapping(value = "/student/view.do", method = RequestMapping.Method.GET)

public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String studentId = req.getParameter("id");
        if (Objects.isNull(studentId)) {
            log.error("아이디가 널");
            return "/error";
        }

        Student student = studentRepository.getStudentById(studentId);
        if (Objects.isNull(student)) {
            log.error("존재하지 않음 : "+studentId);

            return"/error";
        }

        String update = "/student/update?id=" + studentId;
        req.setAttribute("update_link",update);

        String delete = "/student/delete?id=" + studentId;
        req.setAttribute("delete_link",delete);

        req.setAttribute("student",student);


        return "/student/view.jsp";
    }
}
