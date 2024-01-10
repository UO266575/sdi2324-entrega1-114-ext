package com.uniovi.sdimywallapop;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    private String message;
    private String redirectUrl;

    public CustomAccessDeniedHandler(String message, String redirectUrl) {
        this.message = message;
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        request.setAttribute("message", message);
        response.sendRedirect(request.getContextPath() + redirectUrl);
    }
}

