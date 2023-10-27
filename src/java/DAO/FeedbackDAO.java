/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Feedbacks;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import myLibrary.DatabaseConnection;

/**
 *
 * @author hendrix
 */
public class FeedbackDAO {

    public static ArrayList<Feedbacks> getAll() throws Exception {
        Connection con;

        ArrayList<Feedbacks> result = new ArrayList<>();
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT [feedback_id]\n"
                        + "      ,[feedback_content]\n"
                        + "      ,[feedback_date]\n"
                        + "      ,[rating]\n"
                        + "      ,[ranking]\n"
                        + "      ,[customer_id]\n"
                        + "      ,[order_id]\n"
                        + "  FROM [flower_shop].[dbo].[Feedback]";
                PreparedStatement pts = con.prepareStatement(sql);

                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {

                    int feedback_id = rs.getInt("feedback_id");
                    String feedback_content = rs.getString("feedback_content");
                    java.util.Date feedback_date = rs.getDate("feedback_date");
                    int rating = rs.getInt("rating");
                    int ranking = rs.getInt("ranking");
                    int customer_id = rs.getInt("customer_id");
                    int order_id = rs.getInt("order_id");

                    Feedbacks feed = new Feedbacks(feedback_id, feedback_content, feedback_date, rating, ranking, customer_id, order_id);

                    result.add(feed);
                }
                con.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return result;
    }

    public static int CreateFeedback(
                String feedback_content,
                Date feedback_date,
                int rating,
                int ranking,
                int customer_id,
                int order_id) {
        Connection con = null;

        PreparedStatement pts = null;
        int result = 0;
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[Feedback]\n"
                        + "           ([feedback_content]\n"
                        + "           ,[feedback_date]\n"
                        + "           ,[rating]\n"
                        + "           ,[ranking]\n"
                        + "           ,[order_id]\n"
                        + "           ,[customer_id])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?,?)";

                pts = con.prepareStatement(sql);
                pts.setString(1, feedback_content);
                pts.setDate(2, (java.sql.Date) feedback_date);
                pts.setInt(3, rating);
                pts.setInt(4, ranking);
                pts.setInt(5, customer_id);
                pts.setInt(6, order_id);
                
                ResultSet rs = pts.executeQuery();
                result = pts.executeUpdate();
            }

        } catch (Exception ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
