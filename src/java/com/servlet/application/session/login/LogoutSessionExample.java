/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application.session.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aakash
 */
public class LogoutSessionExample extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        if (session.getAttribute("isLoggedIn") != null && Boolean.parseBoolean(session.getAttribute("isLoggedIn").toString())) {
            session.removeAttribute("isLoggedIn");
            writer.println("Logged out successfully!");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request!");
        }
    }
}
