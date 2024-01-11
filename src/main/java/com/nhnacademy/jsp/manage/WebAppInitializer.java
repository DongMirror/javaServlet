package com.nhnacademy.jsp.manage;

import com.nhnacademy.jsp.manage.controller.ControllerFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@Slf4j
@HandlesTypes(value = {com.nhnacademy.jsp.manage.controller.Command.class})
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        ControllerFactory controllerFactory = new ControllerFactory();
        try {
            controllerFactory.init(set);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        servletContext.setAttribute("controllerFactory",controllerFactory);
    }
}
