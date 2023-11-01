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
public class Shippers {
      int shipper_id;
      String name;
      Date birth_date;
      String phone_number;
      String address;
      String email;
      String password;
      boolean status;
      int order_assigned;

    public Shippers() {
    }

    public Shippers(int shipper_id, String name, Date birth_date, String phone_number, String address, String email, String password, boolean status, int order_assigned) {
        this.shipper_id = shipper_id;
        this.name = name;
        this.birth_date = birth_date;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.password = password;
        this.status = status;
        this.order_assigned = order_assigned;
    }

    public int getOrder_assigned() {
        return order_assigned;
    }

    public void setOrder_assigned(int order_assigned) {
        this.order_assigned = order_assigned;
    }

   

    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
      
      
}
