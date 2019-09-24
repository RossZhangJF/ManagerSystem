package com.ross.manger.info.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class HTTPFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig=config;
        init();
    }

    protected void init()throws ServletException{};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        doFilter(request,response,filterChain);
    }

    protected abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException ;

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    @Override
    public void destroy() {    }
}
