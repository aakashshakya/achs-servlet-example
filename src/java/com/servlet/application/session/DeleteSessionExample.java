/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application.session;

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
public class DeleteSessionExample extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        if (session.getAttribute("username") != null) {
            writer.println("The username before removing session is " + session.getAttribute("username"));
        }
        
        session.invalidate();   //Removes all the session information
        writer.println("Session removed.");
    }
}
