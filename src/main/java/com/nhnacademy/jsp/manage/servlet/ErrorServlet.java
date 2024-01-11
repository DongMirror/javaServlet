package com.nhnacademy.jsp.manage.servlet;

import com.nhnacademy.jsp.manage.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.nhnacademy.jsp.manage.RequestDispatcher.*;

@WebServlet(name = "errorServlet", urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("status_code",req.getAttribute(ERROR_STATUS_CODE));
//        req.setAttribute("exception_type",req.getAttribute(ERROR_EXCEPTION_TYPE));
//        req.setAttribute("message",req.getAttribute(ERROR_MESSAGE));
//        req.setAttribute("exception",req.getAttribute(ERROR_EXCEPTION));
//        req.setAttribute("request_url",req.getAttribute(ERROR_REQUEST_URI));
//
//        RequestDispatcher dispatcher = (RequestDispatcher) req.getRequestDispatcher("/error.jsp");
//        dispatcher.forward(req,resp);
    }
}
