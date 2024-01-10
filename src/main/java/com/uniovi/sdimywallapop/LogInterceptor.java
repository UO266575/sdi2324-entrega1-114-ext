package com.uniovi.sdimywallapop;

import com.uniovi.sdimywallapop.entities.Log;
import com.uniovi.sdimywallapop.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class LogInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LogServices logServices;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String controllerMethodName = handlerMethod.getMethod().getName();
            String mapping = "";
            if(handlerMethod.getMethodAnnotation(RequestMapping.class).value().length > 0){
                mapping = handlerMethod.getMethodAnnotation(RequestMapping.class).value()[0];
            }
            String message = String.format("Mapeo: %s %s",
                    controllerMethodName, mapping);
            logServices.addLog(new Log("PET", new Date(), message));
        }
        return true;
    }

}
