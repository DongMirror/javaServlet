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
@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("id");
        if (Objects.isNull(studentId)) {
            log.error("아이디가 널");
            resp.sendRedirect("/error");
            return;
        }

        Student student = studentRepository.getStudentById(studentId);
        if (Objects.isNull(student)) {
            log.error("존재하지 않음 : "+studentId);
            resp.sendRedirect("/error");
            return;
        }

        String update = "/student/update?id=" + studentId;
        req.setAttribute("update_link",update);

        String delete = "/student/delete?id=" + studentId;
        req.setAttribute("delete_link",delete);

        req.setAttribute("student",student);

//        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/view.jsp");
//        dispatcher.forward(req,resp);
        req.setAttribute("view","/student/view.jsp");


    }
}
