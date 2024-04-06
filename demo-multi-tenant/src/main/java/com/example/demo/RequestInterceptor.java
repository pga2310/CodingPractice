package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private TenantContext tenantContext;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Extract the tenant ID from the request and set it in the TenantContext
        String tenantId = extractTenantId(request);
        tenantContext.setCurrentTenant(tenantId);
        return true;
    }

    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // Clear the tenant context after the request is processed
        tenantContext.clear();
    }

    private String extractTenantId(HttpServletRequest request) {
        // Logic to extract tenant ID from the request
        // For example, from request headers, URL parameters, etc.
        return "tenant1"; 
    }
}

