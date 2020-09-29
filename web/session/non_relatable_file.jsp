<%-- 
    Document   : non_relatable_file
    Created on : Sep 21, 2020, 8:41:45 AM
    Author     : aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String username = (String) session.getAttribute("username"); %>
        <h1>Session username is <%=username%></h1>
    </body>
</html>
