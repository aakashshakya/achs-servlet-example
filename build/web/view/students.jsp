<%@page import="com.servlet.application.mvc.model.Students"%>
<%@page import="java.util.List"%>
<%--<%@include file="includes/header.jsp" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Students List Example</title>

        <!-- CSS only -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <style>
            .add-btn {
                margin-top: 20px;
                margin-bottom: 20px;
                margin-right: 20px;
            }
            .contaner {
                position: relative;
            }
            .student-form {
                width: 900px;
                position: absolute;
                top: 50%;
                left: 65%;
                transform: translate(-50%,-50%);
            }
        </style>
    </head>
    <body>
        <div class="container">

<%
    List<Students> students = (List<Students>) request.getAttribute("students");
    if (students != null && students.size() > 0) {

%>
<div>
    <a href="<%=application.getContextPath()%>/view/add_student.jsp" class="add-btn btn btn-success float-right">Add New Student</a>
</div>
<table class="table table-stripped">
    <tr>
        <th>ID</th>
        <th>Student Name</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Gender</th>
        <th>Action</th>
    </tr>
    <% for (Students student : students) {%>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getStudentName()%></td>
        <td><%=student.getAddress()%></td>
        <td><%=student.getContactNumber()%></td>
        <td><%=student.getGender()%></td>
        <td>
            <a class="btn btn-success">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="btn btn-danger">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
<% } else { %>
<h1>No students found.</h1>
<% }%>



<%@include file="includes/footer.jsp" %>