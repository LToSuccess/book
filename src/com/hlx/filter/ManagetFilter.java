package com.hlx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author hlx
 * @create 2020-08-13 9:00
 */
public class ManagetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
