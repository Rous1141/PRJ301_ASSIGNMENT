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
                    java.util.Date order_date = rs.getDate("order_date");
                    java.util.Date delivery_date = rs.getDate("delivery_date");
                    Boolean status = rs.getBoolean("status");
                    int shipping_cost = rs.getInt("shipping_cost");
                    int total_value = rs.getInt("total_value");
                    String payment_method = rs.getString("payment_method");
                    String delivery_address = rs.getString("delivery_address");
                    int customer_id = rs.getInt("customer_id");
                    int flower_id = rs.getInt("flower_id");
                    int flower_total_price = rs.getInt("flower_total_price");
                    int shipping_total_price = rs.getInt("shipping_total_price");
                    int total_payment = rs.getInt("total_payment");

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

    public static int updateOrder(int ID) throws Exception {
        int result = 0;
        try {
            Connection cn = DatabaseConnection.makeConnection();

            if (cn != null) {
                String sql = "UPDATE [dbo].[Orders]\n"
                        + "SET [status] = 0\n"
                        + "WHERE [order_id] = ?";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, ID);

                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
