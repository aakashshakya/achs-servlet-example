<%-- 
    Document   : check_session
    Created on : Sep 20, 2020, 11:08:05 PM
    Author     : aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Session Page</title>
    </head>
    <body>
        <%!
            String stackUsername = "admin";
            String stackPassword = "password";
        %>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String sessionUsername = (String) session.getAttribute("username");
            System.out.println("The session username is " + sessionUsername);
            if (sessionUsername == null) {
                if (username != null && username.equals(stackUsername) && password != null && password.equals(stackPassword)) {
                    System.out.println("User logged in successfully");
                    session.setAttribute("username", username);
                    sessionUsername = username;
                } else {
                    System.out.println("Invalid Username or password entered.");
                    response.sendRedirect(application.getContextPath() + "/session/session_example.jsp");
                }
            }
        %>
        <h1>Welcome, You are logged in as <%=sessionUsername%></h1>
    </body>
</html>
