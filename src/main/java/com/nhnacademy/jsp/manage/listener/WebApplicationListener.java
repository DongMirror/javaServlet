package com.nhnacademy.jsp.manage.listener;

import com.nhnacademy.jsp.manage.Gender;
import com.nhnacademy.jsp.manage.Student;
import com.nhnacademy.jsp.manage.repository.JsonStudentRepository;
import com.nhnacademy.jsp.manage.repository.MapStudentRepository;
import com.nhnacademy.jsp.manage.repository.StudentRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Random;
@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new JsonStudentRepository();
        Random random = new Random();

        for(int i=1;i<=10;i++) {
            Student student = new Student();
            student.setId(String.valueOf(i));
            student.setName("아카데미" + i);
            student.setGender(Gender.values()[random.nextInt(Gender.values().length)]);
//            student.setCreatedAt(LocalDateTime.now());
            student.setAge(random.nextInt(11) + 20);
            studentRepository.save(student);
        }
        context.setAttribute("studentRepository",studentRepository);
    }
}
