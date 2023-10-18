/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author hendrix
 */
public class Customers {
    private String ID;
    private String email;
    private String fullName;
    private Date birthDate;
    private String phone;
    private String address;
    private boolean status;
    private String order;

    public Customers() {
        ID=" ";
        email="";
        fullName="";
        
    }

    public Customers(String ID, String email, String fullName, Date birthDate, String phone, String address, boolean status, String order) {
        this.ID = ID;
        this.email = email;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.order = order;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
    
    
    
}
