/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application.mvc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.servlet.application.mvc.model.Students;
import java.io.IOException;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aakash
 */
public class StudentDAO {

    private final String url = "jdbc:mysql://localhost:3306/school_information_system?verifyServerCertificate=false&useSSL=false&requireSSL=false";
    private final String dbUsername = "root";
    private final String dbPassword = "password";
    private final String driverName = "com.mysql.jdbc.Driver";
    private Connection connection;
    private String sql = "";

    private void connection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        connection = DriverManager.getConnection(url, dbUsername, dbPassword);
    }

    public List<Students> getAllStudents() throws ClassNotFoundException, SQLException {
        List<Students> allStudents = new ArrayList<>();
        try {
            sql = "Select * from students";

            connection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String studentName = resultSet.getString("full_name");
                String address = resultSet.getString("address");
                String contactNumber = resultSet.getString("contact_number");
                String gender = resultSet.getString("gender");

                allStudents.add(new Students(id, studentName, address, contactNumber, gender));
            }
        } finally {
            disconnect();
        }
        return allStudents;
    }

    public void addStudent(Students student, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
        System.out.println("Request to save student information with data " + student.toString());
        validateStudentInformation(student, response);
        try {
            connection();
            sql = "Insert into students (full_name, address, contact_number, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, student.getStudentName());
            prepareStatement.setString(2, student.getAddress());
            prepareStatement.setString(3, student.getContactNumber());
            prepareStatement.setString(4, student.getGender());
            int isInserted = prepareStatement.executeUpdate();
            if (isInserted == 1) {
                System.out.println("Record added successfully.");
            }
        } finally {
            disconnect();
        }
    }

    private void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    private void validateStudentInformation(Students student, HttpServletResponse response) throws IOException, ServletException {
        if(student == null) {
            throw new ServletException("Invalid request.");
        }
        if((student.getStudentName() == null) || student.getStudentName().equals("")) {
            System.err.println("Invalid name added");
            throw new ServletException("Student name cannot be empty.");
        }
        if((student.getAddress()== null) || student.getAddress().equals("")) {
            System.err.println("Invalid address added");
            throw new ServletException("Student address cannot be empty.");
        }
        if((student.getContactNumber()== null) || student.getContactNumber().equals("")) {
            System.err.println("Invalid contact number added");
            throw new ServletException("Student contact number cannot be empty.");
        }
        if((student.getGender()== null) || student.getGender().equals("")) {
            System.err.println("Invalid gender added");
            throw new ServletException("Student gender cannot be empty.");
        }
    }
}
