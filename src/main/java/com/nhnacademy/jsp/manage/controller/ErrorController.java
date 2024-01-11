package com.nhnacademy.jsp.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.nhnacademy.jsp.manage.RequestDispatcher.*;

public class ErrorController  implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse response) {
        req.setAttribute("status_code",req.getAttribute(ERROR_STATUS_CODE));
        req.setAttribute("exception_type",req.getAttribute(ERROR_EXCEPTION_TYPE));
        req.setAttribute("message",req.getAttribute(ERROR_MESSAGE));
        req.setAttribute("exception",req.getAttribute(ERROR_EXCEPTION));
        req.setAttribute("request_url",req.getAttribute(ERROR_REQUEST_URI));

//        RequestDispatcher dispatcher = (RequestDispatcher) req.getRequestDispatcher("/error");
//        dispatcher.forward(req,response);

        return "/error.do";
    }
}
