/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet.application.mvc.model;

/**
 *
 * @author aakash
 */
public class Students {
    private int id;
    private String studentName;
    private String address;
    private String contactNumber;
    private String gender;

    public Students() {
    }

    public Students(int id, String studenName, String address, String contactNumber, String gender) {
        this.id = id;
        this.studentName = studenName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studenName) {
        this.studentName = studenName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Students{" + "studentName=" + studentName + ", address=" + address + ", contactNumber=" + contactNumber + ", gender=" + gender + '}';
    }
    
    
    
}
