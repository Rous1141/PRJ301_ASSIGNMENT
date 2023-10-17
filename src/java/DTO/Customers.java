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
  int customer_id;

   
    String  name;
     Date birth_date;
     String phone_number;
    String  address;
     boolean status;
     String orders;
      public Customers() {
    }

    public Customers(int customer_id, String name, Date birth_date, String phone_number, String address, boolean status, String orders) {
        this.customer_id = customer_id;
        this.name = name;
        this.birth_date = birth_date;
        this.phone_number = phone_number;
        this.address = address;
        this.status = status;
        this.orders = orders;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }
      
}
