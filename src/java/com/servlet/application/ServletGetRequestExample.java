/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aakash
 */
public class ServletGetRequestExample extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        String[] hobbiesArray = request.getParameterValues("hobbies");
        String hobbiesList = "";
        
        for(String hobby: hobbiesArray) {
            hobbiesList += hobby + ",";
        }
        
        PrintWriter writer = response.getWriter();
        writer.println("The name passed on the request is " + name);
        writer.println("The age passed on the request is " + age);
        writer.println("The hobbies passed on the request is " + hobbiesList);
        
        writer.println("Printing values using enumeration:");
        Enumeration<String> parameters = request.getParameterNames();
        while(parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();
            String value = request.getParameter(parameter);
            writer.println(parameter + " = " + value);
        }
    }
    
}
