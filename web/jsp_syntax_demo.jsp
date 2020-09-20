<%-- 
    Document   : jsp_syntax_demo
    Created on : Sep 20, 2020, 8:12:42 AM
    Author     : aakash
--%>

<%@page import="java.util.Date"%> <%-- This is JSP directives --%>
<%@page import="com.servlet.application.mvc.model.Students" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! int number;%>   <!--This is declaration tag this will be seen in page source-->
        <%! String studentName = "Dipesh Wosti";%>   <!--This is declaration tag this will be seen in page source-->
        <%-- this is just a test of for loop this will not be seen in page source --%>
        <h1><%=studentName%></h1> <!-- This value is printed using JSP expression tag -->
        <% for (number = 0; number < 3; number++) { %>
        <h3>Hello CSIT students of ACHS. <%=number%></h3>
        <%="I am using JSP expression tag"%>
        <% }%>
        <% Students student = new Students(1, "Aakash", "Lagan", "9860706065", "male"); %>
        <hr />
        <%=student.getStudentName()%>
        <hr />
        <jsp:include page="print_date.jsp" />
    </body>
</html>
