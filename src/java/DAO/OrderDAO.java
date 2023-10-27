/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Orders;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import myLibrary.DatabaseConnection;

/**
 *
 * @author hendrix
 */
public class OrderDAO {

    public static ArrayList<Orders> getAllOrders() throws Exception {
        Connection con;

        ArrayList<Orders> result = new ArrayList<>();
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT [order_id]\n"
                        + "      ,[order_date]\n"
                        + "      ,[delivery_date]\n"
                        + "      ,[status]\n"
                        + "      ,[shipping_cost]\n"
                        + "      ,[total_value]\n"
                        + "      ,[payment_method]\n"
                        + "      ,[delivery_address]\n"
                        + "      ,[customer_id]\n"
                        + "      ,[flower_id]\n"
                        + "      ,[flower_total_price]\n"
                        + "      ,[shipping_total_price]\n"
                        + "      ,[total_payment]\n"
                        + "  FROM [flower_shop].[dbo].[Orders]";
                PreparedStatement pts = con.prepareStatement(sql);

                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {

                    int order_id = rs.getInt("order_id");
                    java.util.Date order_date = rs.getDate("order_date'");
                    java.util.Date delivery_date = rs.getDate("delivery_date'");
                    Boolean status = rs.getBoolean("status");
                    int shipping_cost = rs.getInt("order_id");
                    int total_value = rs.getInt("order_id");
                    String payment_method = rs.getString("email");
                    String delivery_address = rs.getString("email");
                    int customer_id = rs.getInt("order_id");
                    int flower_id = rs.getInt("order_id");
                    int flower_total_price = rs.getInt("order_id");
                    int shipping_total_price = rs.getInt("order_id");
                    int total_payment = rs.getInt("order_id");

                    Orders order = new Orders(order_id, order_date, delivery_date, status, shipping_cost, total_value, payment_method, delivery_address, customer_id, flower_id, flower_total_price, shipping_total_price, total_payment);

                    result.add(order);
                }
                con.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return result;
    }
}
