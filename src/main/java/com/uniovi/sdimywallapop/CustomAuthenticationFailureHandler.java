package com.uniovi.sdimywallapop;

import com.uniovi.sdimywallapop.entities.Log;
import com.uniovi.sdimywallapop.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private LogServices logServices;

    public CustomAuthenticationFailureHandler(){

    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        logServices.addLog(new Log("LOGIN-ERR", new Date(), username));
        response.sendRedirect("/login");
    }
}

