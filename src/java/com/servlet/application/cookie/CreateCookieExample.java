/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

/**
 *
 * @author aakash
 */

public class CreateCookieExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Cookie nameCookie = new Cookie("full_name", name);
        response.addCookie(nameCookie);
        PrintWriter writer = response.getWriter();
        writer.print("Cookie added");
    }
}
