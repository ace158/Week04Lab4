/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Domain.Classes.User;
import Domain.Classes.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 697148
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        Cookie[] cookies = request.getCookies();
        String cookieName = "cookieID";
        String cookieValue = "";
        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                cookieValue = cookie.getValue();
            }
        }

        if ("logout".equals(action)) {
            request.getSession().invalidate();
            request.setAttribute("message", "you have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("usrname");
        String password = request.getParameter("psswd");
        String remember = request.getParameter("remember");

        username = username.toLowerCase();
        password = password.toLowerCase();

        request.setAttribute("username", username);
        request.setAttribute("password", password);

        UserService us;
        us = new UserService();
        User u = new User(username, password, remember);

        if (username.trim().isEmpty() && password.trim().isEmpty()) {
            request.setAttribute("message", "both values are required");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (!us.login(username, password)) {
            request.setAttribute("message", "invalid username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            u.setUsername(username);
            HttpSession session = request.getSession();
            session.setAttribute("User", u);
        }

        if (remember != null) {
            u.setRemember(remember);
            Cookie c = new Cookie("cookieID", username);
            c.setMaxAge(60 * 60);
            c.setPath("/");
            response.addCookie(c);
            response.sendRedirect("home");
        } else if (remember == null) {
            u.setRemember(null);
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);

            }
            response.sendRedirect("home");
        }

    }

}
