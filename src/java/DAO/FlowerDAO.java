/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Flowers;
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
public class FlowerDAO {

    public static ArrayList<Flowers> getFlower() {
        ArrayList<Flowers> result = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT [flower_id]\n"
                        + "      ,[flower_name]\n"
                        + "      ,[flower_color]\n"
                        + "      ,[flower_price]\n"
                        + "      ,[status]\n"
                        + "      ,[import_date]\n"
                        + "      ,[category_id]\n"
                        + "      ,[image]\n"
                        + "  FROM [flower_shop].[dbo].[Flower]";

                PreparedStatement pts = con.prepareStatement(sql);
                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {
                   
                    
                    int flower_id = rs.getInt("flower_id");
                    String flower_name = rs.getString("flower_id");
                    String flower_color = rs.getString("flower_id");
                    int flower_price = rs.getInt("flower_id");
                    boolean status = rs.getBoolean("flower_id");
                    Date import_date = rs.getDate("flower_id");
                    int category_id = rs.getInt("flower_id");
                    String image = rs.getString("flower_id");

                    Flowers flower = new Flowers(flower_id, flower_name, flower_color, flower_price, status, import_date, category_id, image);
                    result.add(flower);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
