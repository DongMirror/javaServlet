package com.nhnacademy.jsp.manage.controller;

import com.nhnacademy.jsp.manage.Gender;
import com.nhnacademy.jsp.manage.RequestMapping;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
@Slf4j
@RequestMapping(value = "/student/update.do", method = RequestMapping.Method.POST)

public class StudentUpdateController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

            String id = req.getParameter("id");
            if (Objects.isNull(id)) {
                log.error("아이디가 비어있음");
                return "/error";
            }
            Student student = studentRepository.getStudentById(id);
            if (Objects.isNull(student)) {
                log.error("일치하는 아이디가 없음");
                return "/error";
            }
            String name = req.getParameter("name");
            Gender gender = Gender.valueOf(req.getParameter("gender"));
            int age = Integer.parseInt(req.getParameter("age"));
            student.setName(name);
            student.setGender(gender);
            student.setAge(age);
            studentRepository.update(student);

//        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/view.jsp");
//        dispatcher.forward(req,resp);

        return "redirect/view.do?id="+id;

    }
}
