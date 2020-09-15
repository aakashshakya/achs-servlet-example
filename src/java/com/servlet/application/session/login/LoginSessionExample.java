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
public class LoginSessionExample extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String dbUsername = "aakash";
        String dbPassword = "password";

        String requestUsername = request.getParameter("username");
        String requestPassword = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        
        if (session.getAttribute("isLoggedIn") != null && Boolean.parseBoolean(session.getAttribute("isLoggedIn").toString())) {
            writer.println("You are already logged in.");
        } else {
            if (requestUsername != null && requestPassword != null) {
                if (requestUsername.equals(dbUsername) && requestPassword.equals(dbPassword)) {
                    session.setAttribute("isLoggedIn", true);
                    writer.println("Logged in successfully.");
                } else {
                    writer.println("Invalid Username or Password!!");
                }

            } else {
                writer.println("Invalid Request!!");
            }
        }
        writer.close();
    }
}
