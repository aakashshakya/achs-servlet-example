<%-- 
    Document   : first
    Created on : Sep 18, 2020, 8:33:24 AM
    Author     : aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <% out.println("This is first file created in jsp."); %>
        <div>
            <form method="POST" action="<%= application.getContextPath()%>/login">
                Enter username: <input type="text" name="username" /> <br>
                Enter password: <input type="password" name="password" /> <br>
                <input type="submit" /> <br>
            </form>
        </div>
        
    </body>
</html>
