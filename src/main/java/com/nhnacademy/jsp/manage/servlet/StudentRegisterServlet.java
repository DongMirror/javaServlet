package com.nhnacademy.jsp.manage.servlet;

import com.nhnacademy.jsp.manage.Gender;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.MapStudentRepository;
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
@Slf4j
@WebServlet(name = "studentRegisterServlet",urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {
    private StudentRepository studentRepository;

  @Override
    public void init(ServletConfig config) throws ServletException {
      studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
  }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/student/register.jsp");
//        dispatcher.forward(req,response);

        req.setAttribute("view","/student/register.jsp");

    }
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    String genderValue = req.getParameter("gender");
    Gender gender = Gender.valueOf(genderValue);

    Student s = new Student();
    s.setGender(gender);

    String id = req.getParameter("id");
    String name = req.getParameter("name");
    Gender gender2 = Gender.valueOf(req.getParameter("gender"));
    int age = Integer.parseInt(req.getParameter("age"));
    log.info(String.valueOf(gender2));
    studentRepository.save(new Student(id,name,gender2,age));

    req.setAttribute("view","redirect/view.do?id="+id);
//     response.sendRedirect("/student/view?id="+id);



    }

}
