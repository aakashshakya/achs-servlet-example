/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application.mvc.controller;

import com.servlet.application.mvc.model.dao.StudentDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.servlet.application.mvc.model.Students;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aakash
 */
public class StudentController extends HttpServlet {
    private final StudentDAO studentDAO;
    
    public StudentController() {
        this.studentDAO = new StudentDAO();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Students> students = new ArrayList<>();
        try {
            students = studentDAO.getAllStudents();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQL exception occurred." + ex.getMessage());
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("/view/students.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Students student = new Students();
        student.setStudentName(request.getParameter("student_name"));
        student.setAddress(request.getParameter("address"));
        student.setContactNumber(request.getParameter("contact_number"));
        student.setGender(request.getParameter("gender"));
        
        try {
            studentDAO.addStudent(student, response);
            response.sendRedirect("/ServletApplication/students");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQL exception occurred." + ex.getMessage());
        }
    }

}
