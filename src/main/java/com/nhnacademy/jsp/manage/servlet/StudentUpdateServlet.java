package com.nhnacademy.jsp.manage.servlet;

import com.nhnacademy.jsp.manage.Gender;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
@Slf4j
@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException{
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Objects.nonNull(studentRepository)){
            String id = req.getParameter("id");
            Student student = studentRepository.getStudentById(id);
            req.setAttribute("student",student);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/student/register.jsp");
//            dispatcher.forward(req, resp);

            req.setAttribute("view","/student/register.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (Objects.isNull(id)) {
            log.error("아이디가 비어있음");
            resp.sendRedirect("/error");
            return;
        }
        Student student = studentRepository.getStudentById(id);
        if (Objects.isNull(student)) {
            log.error("일치하는 아이디가 없음");
            resp.sendRedirect("/error");
            return;
        }
        String name = req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));
        student.setName(name);
        student.setGender(gender);
        student.setAge(age);
        studentRepository.update(student);

//        resp.sendRedirect("/student/view?id="+id);
        req.setAttribute("view","redirect/view.do?id="+id);





    }
}
