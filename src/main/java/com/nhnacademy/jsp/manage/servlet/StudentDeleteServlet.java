package com.nhnacademy.jsp.manage.servlet;

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
@WebServlet(name = "studentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException{
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (Objects.isNull(id)) {
            log.error("id가 비어있습니다");
            throw new RuntimeException();
        }
        Student student = studentRepository.getStudentById(id);

        if (Objects.isNull(student)) {
            log.error("일치하는 아이디가 없음");
            resp.sendRedirect("/error");
            return;
        }
        studentRepository.deleteById(id);

//        resp.sendRedirect("/student/list");
        req.setAttribute("view","redirect/list.do");

    }
}
