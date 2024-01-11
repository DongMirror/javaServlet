package com.nhnacademy.jsp.manage.controller;

import com.nhnacademy.jsp.manage.Gender;
import com.nhnacademy.jsp.manage.RequestMapping;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping(value = "/student/register.do", method = RequestMapping.Method.POST)

public class StudentRegisterController implements Command {
    String id =null;
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse response) {
        if (req.getMethod().equals("GET")) {
            return "/student/register.jsp";
        }
        if (req.getMethod().equals("POST")) {

            StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
            String genderValue = req.getParameter("gender");
            Gender gender = Gender.valueOf(genderValue);

            Student s = new Student();
            s.setGender(gender);

             id = req.getParameter("id");
            String name = req.getParameter("name");
            Gender gender2 = Gender.valueOf(req.getParameter("gender"));
            int age = Integer.parseInt(req.getParameter("age"));
            log.info(String.valueOf(gender2));
            studentRepository.save(new Student(id,name,gender2,age));


        }
        return "redirect/view.do?id="+id;
    }
}
