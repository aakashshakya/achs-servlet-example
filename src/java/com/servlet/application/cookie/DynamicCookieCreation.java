/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aakash
 */
public class DynamicCookieCreation extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Enumeration<String> parameters = request.getParameterNames();
        while(parameters.hasMoreElements()) {
            String param = parameters.nextElement();
            String value = request.getParameter(param);
            
            Cookie cookie = new Cookie(param, value);
            response.addCookie(cookie);
        }
        
       
        PrintWriter writer = response.getWriter();
        writer.println("Cookie added");
        
        writer.close();
    }    
}
