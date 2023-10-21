/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Category;
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
                        + "      ,[quantity]\n"
                        + "  FROM [flower_shop].[dbo].[Flower]";

                PreparedStatement pts = con.prepareStatement(sql);
                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {

                    int flower_id = rs.getInt("flower_id");
                    String flower_name = rs.getString("flower_name");
                    String flower_color = rs.getString("flower_color");
                    int flower_price = rs.getInt("flower_price");
                    boolean status = rs.getBoolean("status");
                    Date import_date = rs.getDate("import_date");
                    int category_id = rs.getInt("category_id");
                    int quantity = rs.getInt("quantity");
                    String image = rs.getString("image");

                    Flowers flower = new Flowers(flower_id, flower_name, flower_color, flower_price, status, import_date, category_id, image, quantity);
                    result.add(flower);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static ArrayList<Flowers> getFlowerByName(String name) {
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
                        + "      ,[quantity]\n"
                        + "  FROM [flower_shop].[dbo].[Flower]\n"
                        + "  where [flower_name] like ? ";

                PreparedStatement pts = con.prepareStatement(sql);
                pts.setString(1, "%" + name + "%");
                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {

                    int flower_id = rs.getInt("flower_id");
                    String flower_name = rs.getString("flower_name");
                    String flower_color = rs.getString("flower_color");
                    int flower_price = rs.getInt("flower_price");
                    boolean status = rs.getBoolean("status");
                    Date import_date = rs.getDate("import_date");
                    int category_id = rs.getInt("category_id");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");

                    Flowers flower = new Flowers(flower_id, flower_name, flower_color, flower_price, status, import_date, category_id, image, quantity);
                    result.add(flower);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static ArrayList<Flowers> getFlowerByID(String id) {
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
                        + "      ,[quantity]\n"
                        + "  FROM [flower_shop].[dbo].[Flower]\n"
                        + "  where [flower_id] like ? ";

                PreparedStatement pts = con.prepareStatement(sql);
                pts.setString(1, id);
                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {

                    int flower_id = rs.getInt("flower_id");
                    String flower_name = rs.getString("flower_name");
                    String flower_color = rs.getString("flower_color");
                    int flower_price = rs.getInt("flower_price");
                    boolean status = rs.getBoolean("status");
                    Date import_date = rs.getDate("import_date");
                    int category_id = rs.getInt("category_id");
                    String image = rs.getString("image");
                    int quantity = rs.getInt("quantity");
                    Flowers flower = new Flowers(flower_id, flower_name, flower_color, flower_price, status, import_date, category_id, image, flower_id);
                    result.add(flower);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static ArrayList<Category> getAllCategory() {
        ArrayList<Category> results = new ArrayList<>();
        try {
            Connection con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT [category_id]\n"
                        + "      ,[category_name]\n"
                        + "      ,[flower_season]\n"
                        + "      ,[flower_meaning]\n"
                        + "  FROM [dbo].[Category]";

                PreparedStatement pts = con.prepareStatement(sql);

                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {

                    int category_id = rs.getInt("category_id");
                    String category_name = rs.getString("category_name");
                    String flower_session = rs.getString("flower_season");
                    String flower_meaning = rs.getString("flower_meaning");

                    Category cate = new Category(category_id, category_name, flower_session, flower_meaning);
                    results.add(cate);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }

    public static int CreateFlowers(String flower_name, String flower_color, int flower_price, boolean status,
            Date import_date, int category_id, String image, int quantity) {
        Connection con = null;

        PreparedStatement pts = null;
        int result = 0;
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].Flower\n"
                        + "           ([flower_name]\n"
                        + "           ,[flower_color]\n"
                        + "           ,[flower_price]\n"
                        + "           ,[status]\n"
                        + "           ,[import_date]\n"
                        + "           ,[category_id]\n"
                        + "           ,[image])\n"
                        + "           ,[quantity]\n"
                        + "     VALUES\n"
                        + "          ( ? , ? , ? ,?, ? , ? ,? ,?)\n"
                        + "\n"
                        + "\n"
                        + "";

                pts = con.prepareStatement(sql);
                pts.setString(1, flower_name);
                pts.setString(2, flower_color);
                pts.setInt(3, flower_price);
                pts.setBoolean(4, status);
                pts.setDate(5, (java.sql.Date) import_date);
                pts.setInt(6, category_id);
                pts.setString(7, image);
                pts.setInt(8, quantity);
                ResultSet rs = pts.executeQuery();
                result = pts.executeUpdate();
            }

        } catch (Exception ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public static int updateFlower(int id, String name, String color,
            int price, Boolean status, String import_day, int categery_id, String image, int quantity) {
        Connection con = null;

        PreparedStatement pts = null;
        int result = 0;
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "UPDATE [dbo].[Flower]\n"
                        + "   SET [flower_name] =?\n"
                        + "      ,[flower_color] = ?\n"
                        + "      ,[flower_price] = ?\n"
                        + "      ,[status] = ?\n"
                        + "      ,[import_date] =? \n"
                        + "      ,[category_id] =? \n"
                        + "      ,[image] = ?\n"
                        + "      , [quantity] = ?\n"
                        + " Where [flower_id] = ?\n"
                        + "\n"
                        + "\n"
                        + "";
                pts = con.prepareStatement(sql);
                pts.setInt(8, id);
                pts.setString(1, name);
                pts.setString(2, color);
                pts.setInt(3, price);
                pts.setBoolean(4, status);
                pts.setDate(5, java.sql.Date.valueOf(import_day));
                pts.setInt(6, categery_id);
                pts.setString(7, image);
                pts.setInt(8, quantity);
                result = pts.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

}
