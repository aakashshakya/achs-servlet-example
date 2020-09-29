<%-- 
    Document   : divide
    Created on : Sep 20, 2020, 10:07:18 PM
    Author     : aakash
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%
    int firstNumber = Integer.parseInt(request.getParameter("first"));
    int secondNumber = Integer.parseInt(request.getParameter("second"));
    out.println("Division of two numbers is " + (firstNumber / secondNumber));
%>