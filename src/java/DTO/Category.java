/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author THY
 */
public class Category {
     private  int category_id;
     private String category_name;
     private String flower_session;
     private String flower_meaning;

    public Category() {
    }

    public Category(int category_id, String category_name, String flower_session, String flower_meaning) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.flower_session = flower_session;
        this.flower_meaning = flower_meaning;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getFlower_session() {
        return flower_session;
    }

    public void setFlower_session(String flower_session) {
        this.flower_session = flower_session;
    }

    public String getFlower_meaning() {
        return flower_meaning;
    }

    public void setFlower_meaning(String flower_meaning) {
        this.flower_meaning = flower_meaning;
    }
     
    
}
