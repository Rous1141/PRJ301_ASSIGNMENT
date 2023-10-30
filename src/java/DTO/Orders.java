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
public class Orders {

    int order_id;
    Date order_date;
    Date delivery_date;
    Boolean status;
    int shipping_cost;
    int total_value;
    String payment_method;
    String delivery_address;
    int customer_id;
    int flower_id;
    int flower_total_price;
    int shipping_total_price;
    int total_payment;

    public Orders() {
    }

    public Orders(int order_id, Date order_date, Date delivery_date, Boolean status, int shipping_cost, int total_value, String payment_method, String delivery_address, int customer_id, int flower_id, int flower_total_price, int shipping_total_price, int total_payment) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.delivery_date = delivery_date;
        this.status = status;
        this.shipping_cost = shipping_cost;
        this.total_value = total_value;
        this.payment_method = payment_method;
        this.delivery_address = delivery_address;
        this.customer_id = customer_id;
        this.flower_id = flower_id;
        this.flower_total_price = flower_total_price;
        this.shipping_total_price = shipping_total_price;
        this.total_payment = total_payment;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(int shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public int getTotal_value() {
        return total_value;
    }

    public void setTotal_value(int total_value) {
        this.total_value = total_value;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(int flower_id) {
        this.flower_id = flower_id;
    }

    public int getFlower_total_price() {
        return flower_total_price;
    }

    public void setFlower_total_price(int flower_total_price) {
        this.flower_total_price = flower_total_price;
    }

    public int getShipping_total_price() {
        return shipping_total_price;
    }

    public void setShipping_total_price(int shipping_total_price) {
        this.shipping_total_price = shipping_total_price;
    }

    public int getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(int total_payment) {
        this.total_payment = total_payment;
    }

    
}
