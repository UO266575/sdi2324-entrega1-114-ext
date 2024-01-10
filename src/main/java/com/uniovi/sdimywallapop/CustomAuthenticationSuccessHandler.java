package com.uniovi.sdimywallapop;

import com.uniovi.sdimywallapop.entities.Log;
import com.uniovi.sdimywallapop.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private LogServices logServices;

    public CustomAuthenticationSuccessHandler(){

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        logServices.addLog(new Log("LOGIN-EX", new Date(), username));
        List<String> roles = new ArrayList<>();
        for(var x : authentication.getAuthorities()) {
            roles.add(x.toString());
        }
        if (roles.contains("ROLE_ADMIN")) {
            redirectStrategy.sendRedirect(request, response, "/user/list");
        } else {
            redirectStrategy.sendRedirect(request, response, "/offer/myList");
        }
    }

}

