<%@include file="includes/header.jsp" %>

<div class="student-form row">
    <div class="col-md-4">
        <form method="POST" action="<%=application.getContextPath()%>/addStudent">
            <div class="form-group">
                <label>Student's Full Name</label>
                <input type="text" name="studentName" class="form-control" placeholder="Student's Full Name">
            </div>
            <div class="form-group">
                <label>Student's Address</label>
                <input type="text" name="address" class="form-control" placeholder="Student's Full Name">
            </div>
            <div class="form-group">
                <label>Student's Contact number</label>
                <input type="text" class="form-control" placeholder="Student's contact number">
            </div>
            <div class="form-group">
                <label>Student's Gender</label>
                <input type="text" class="form-control" placeholder="Gender">
            </div>
            <button type="submit" class="btn btn-primary">Add student</button>
        </form>
    </div>
</div>

<%@include file="includes/footer.jsp" %>