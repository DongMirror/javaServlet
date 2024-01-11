package com.nhnacademy.jsp.manage.servlet;

import com.nhnacademy.jsp.manage.controller.Command;
import com.nhnacademy.jsp.manage.controller.*;
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
@WebServlet(name = "frontServlet",urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private ControllerFactory controllerFactory;
    private static final String REDIRECT_PREFIX = "redirect";

    @Override
    public void init(ServletConfig config) throws ServletException {
        controllerFactory = (ControllerFactory) config.getServletContext().getAttribute("controllerFactory");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;character=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try{
//            String servletPath = req.getServletPath();
//            String method = req.getMethod();

//            Command command = resolveCommand(servletPath, method);
            Command command = (Command) controllerFactory.getBean(req.getMethod(), req.getServletPath());
            String view = command.execute(req, resp);

            log.info("{}",view);
            if (view != null) {
                if (view.startsWith(REDIRECT_PREFIX)) {
                    log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length()+1));
                    resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()+1));

                } else {
                   RequestDispatcher rd = req.getRequestDispatcher(view);
                    rd.include(req, resp);
                }
            }else{
                throw new ServletException("view Error");
            }
        } catch(Exception ex){

            req.setAttribute("status_code", 500);
            req.setAttribute("exception_type", ex.getClass().getName());
            req.setAttribute("message", ex.getMessage());
            req.setAttribute("exception", ex);


            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
            dispatcher.forward(req,resp);
        }    }

    private String resolveServlet(String servletPath) {
        String processingServlet = null;
        if("/student/list.do".equals(servletPath)){
            processingServlet = "/student/list";
        }if("/student/delete.do".equals(servletPath)){
            processingServlet = "/student/delete";
        }if("/student/register.do".equals(servletPath)){
            processingServlet = "/student/register";
        }if("/student/update.do".equals(servletPath)){
            processingServlet = "/student/update";
        }if("/student/view.do".equals(servletPath)){
            processingServlet = "/student/view";
        }if("/error.do".equals(servletPath)){
            processingServlet = "/error";
        }

        return processingServlet;
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;
        if("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentListController();
//        else if("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
//            command = new StudentRegisterFormController();
//        }else if("/error.do".equals(servletPath)){
//            command = new ErrorController();
        }else if("/student/register.do".equals(servletPath) && ("GET".equalsIgnoreCase(method) ||"POST".equalsIgnoreCase(method))){
            command = new StudentRegisterController();
        }else if("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentDeleteController();
        } else if ("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new StudentViewController();
        }else if("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentUpdateController();
        }else if("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentUpdateFormController();
        }else if("/error.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new ErrorController();
        }

        return command;
    }
}
