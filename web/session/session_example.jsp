<%-- 
    Document   : session_example
    Created on : Sep 20, 2020, 10:59:12 PM
    Author     : aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session example page</title>
    </head>
    <body>
        <form method="POST" action="<%= application.getContextPath()%>/session/check_session.jsp">
            Enter username: <input type="text" name="username" /> <br>
            Enter password: <input type="password" name="password" /> <br>
            <input type="submit" /> <br>
        </form>
    </body>
</html>
