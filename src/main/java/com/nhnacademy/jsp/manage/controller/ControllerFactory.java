package com.nhnacademy.jsp.manage.controller;

import com.nhnacademy.jsp.manage.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
@Slf4j
public class ControllerFactory {

    private final ConcurrentMap<String, Object> beanMap = new ConcurrentHashMap<>();

    public void init(Set<Class<?>> c) throws InstantiationException, IllegalAccessException {
//        for(Class<?> controllerClass : c){
//            RequestMapping requestMapping = controllerClass.getAnnotation(RequestMapping.class);
//            if (requestMapping != null) {
//                String path = requestMapping.value();
//                RequestMapping.Method method = requestMapping.method();
//                String key = method + path;
//
//                try {
//                    Constructor<?> constructor = controllerClass.getConstructor();
//                    Object controllerInstance = constructor.newInstance();
//
//                    beanMap.put(key, controllerInstance);
//                } catch (NoSuchMethodException | InstantiationException |
//                         IllegalAccessException | InvocationTargetException e) {
//                    throw new RuntimeException("Failed to initialize controller: " + controllerClass.getName(), e);
//                }
//            }
//        }

        for (Class<?> clazz : c) {
            if (Objects.nonNull(clazz.getAnnotation(RequestMapping.class))) {
                RequestMapping.Method method = clazz.getAnnotation(RequestMapping.class).method();
                String path = clazz.getAnnotation(RequestMapping.class).value();
                log.info("method: {}, path : {}", method, path);
                beanMap.put(method + path, clazz.newInstance());
            }
        }
    }

    public Object getBean(String method, String path) {
        String key = method + path;
        return beanMap.get(key);
    }
}
