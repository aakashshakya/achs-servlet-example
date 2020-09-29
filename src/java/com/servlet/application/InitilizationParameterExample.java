/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aakash
 */
public class InitilizationParameterExample extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException { 
        ServletConfig config = getServletConfig();
        String dbUserName = config.getInitParameter("dbUsername");
        String dbPassword = config.getInitParameter("dbPassword");
        
        PrintWriter writer = response.getWriter();
        writer.println("The DB username is " + dbUserName);
        writer.println("The DB password is " + dbPassword);
    }
    
}
