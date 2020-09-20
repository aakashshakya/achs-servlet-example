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

    private void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
