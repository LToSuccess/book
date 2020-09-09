package com.hlx.servlet;

import com.hlx.entity.User;
import com.hlx.service.UserService;
import com.hlx.service.serviceImpl.UserServiceImpl;
import com.hlx.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author hlx
 * @create 2020-08-05 19:34
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user = WebUtil.copyParamToBean(req.getParameterMap(), new User());
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(uname)) {
                System.out.println("用户名已存在");
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", uname);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码错误");
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", uname);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("********");
        String username = req.getParameter("uname");
        String password = req.getParameter("upwd");
        User user = WebUtil.copyParamToBean(req.getParameterMap(), new User());
        User login = userService.login(user);
        System.out.println("********"+login.getUid());
        if (login != null) {
            System.out.println("登录成功");
            Cookie cookie = new Cookie("username", login.getUname());
            cookie.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie);
            req.getSession().setAttribute("user", login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}
