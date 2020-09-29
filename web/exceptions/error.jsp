<%-- 
    Document   : error
    Created on : Sep 20, 2020, 10:10:45 PM
    Author     : aakash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage = "true" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exception occurred.</h1>
        <h4>The exception is : <%= exception %></h4>
    </body>
</html>
