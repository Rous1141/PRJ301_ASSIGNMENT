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
public class Feedbacks {
   int feedback_id;
    String  feedback_content;
     Date feedback_date;
     int rating;
     int ranking;
     int customer_id;
    int order_id;

    public Feedbacks() {
    }

    public Feedbacks(int feedback_id, String feedback_content, Date feedback_date, int rating, int ranking, int customer_id, int order_id) {
        this.feedback_id = feedback_id;
        this.feedback_content = feedback_content;
        this.feedback_date = feedback_date;
        this.rating = rating;
        this.ranking = ranking;
        this.customer_id = customer_id;
        this.order_id = order_id;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getFeedback_content() {
        return feedback_content;
    }

    public void setFeedback_content(String feedback_content) {
        this.feedback_content = feedback_content;
    }

    public Date getFeedback_date() {
        return feedback_date;
    }

    public void setFeedback_date(Date feedback_date) {
        this.feedback_date = feedback_date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    
    
    
}
