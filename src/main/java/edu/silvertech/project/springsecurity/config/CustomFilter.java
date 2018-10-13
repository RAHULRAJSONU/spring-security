package edu.silvertech.project.springsecurity.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Component
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()::called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter()::called");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Principal userPrincipal = httpServletRequest.getUserPrincipal();
        System.out.println("userPrincipal::_"+userPrincipal);
    }

    @Override
    public void destroy() {
        System.out.println("destroy()::called");
    }
}
