<%@page import="com.servlet.application.mvc.model.Students"%>
<%@page import="java.util.List"%>
<%@include file="includes/header.jsp" %>
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