/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import DTO.Customers;

import DTO.Customers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myLibrary.DatabaseConnection;

/**
 *
 * @author hendrix
 */
public class CustomerDAO {

    public static ArrayList<Customers> getAll() throws Exception {
        Connection con;

        ArrayList<Customers> result = new ArrayList<>();
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "SELECT [customer_id]\n"
                        + "      ,[email]\n"
                        + "      ,[name]\n"
                        + "      ,[birth_date]\n"
                        + "      ,[phone_number]\n"
                        + "      ,[address]\n"
                        + "       , [flag] \n"
                        + "      ,[status]\n"
                        + "      ,[orders]\n"
                        + "  FROM [dbo].[Customer]";
                PreparedStatement pts = con.prepareStatement(sql);

                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {
                    int id = rs.getInt("customer_id");
                    String mail = rs.getString("email");
                    String name = rs.getString("name");
                    Date birth = rs.getDate("birth_date");
                    String phone = rs.getString("phone_number");
                    String add = rs.getString("address");
                    boolean staus = rs.getBoolean("status");
                    String orders = rs.getString("orders");
                    int flag = rs.getInt("flag");

                    Customers emp = new Customers(id, name, birth, phone, add, mail, staus, orders, flag);

                    result.add(emp);
                }
                con.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return result;
    }

    public static ArrayList<Customers> getCustomersByName(String findname) throws Exception {
        ArrayList<Customers> kq = new ArrayList<>();
        Connection cn = DatabaseConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT [customer_id]\n"
                    + "      ,[email]\n"
                    + "      ,[name]\n"
                    + "      ,[birth_date]\n"
                    + "      ,[phone_number]\n"
                    + "      ,[address]\n"
                    + "       , [flag] \n"
                    + "      ,[status]\n"
                    + "      ,[orders]\n"
                    + "  FROM [dbo].[Customer]\n"
                    + "  where name like ?\n"
                    + "\n"
                    + "\n"
                    + " ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + findname + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("customer_id");
                    String mail = rs.getString("email");
                    String name = rs.getString("name");
                    Date birth = rs.getDate("birth_date");
                    String phone = rs.getString("phone_number");
                    String add = rs.getString("address");
                    boolean staus = rs.getBoolean("status");
                    String orders = rs.getString("orders");
                    int flag = rs.getInt("flag");
                    Customers c = new Customers(id, name, birth, phone, add, mail, staus, orders, flag);
                    kq.add(c);
                }
            }
        }
        return kq;
    }

    public static ArrayList<Customers> getCustomersByEmail(String Email) throws Exception {
        ArrayList<Customers> kq = new ArrayList<>();
        Connection cn = DatabaseConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT [customer_id]\n"
                    + "      ,[email]\n"
                    + "      ,[name]\n"
                    + "      ,[birth_date]\n"
                    + "      ,[phone_number]\n"
                    + "      ,[address]\n"
                    + "       , [flag] \n"
                    + "      ,[status]\n"
                    + "      ,[orders]\n"
                    + "  FROM [dbo].[Customer]\n"
                    + "  where email like ?\n"
                    + "\n"
                    + "\n"
                    + " ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + Email + "%");
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("customer_id");
                    String mail = rs.getString("email");
                    int flag = rs.getInt("flag");
                    String name = rs.getString("name");
                    Date birth = rs.getDate("birth_date");
                    String phone = rs.getString("phone_number");
                    String add = rs.getString("address");
                    boolean staus = rs.getBoolean("status");
                    String orders = rs.getString("orders");
                    Customers c = new Customers(id, name, birth, phone, add, mail, staus, orders, flag);
                    kq.add(c);
                }
            }
        }
        return kq;
    }

    public static int CreateCus(
            String email,
            String name,
            String birth_date,
            String phone_number,
            String address,
            
            Boolean status,
            String orders,
            int flag
    ) {
        Connection con = null;
        PreparedStatement pts = null;
        int result = 0;
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[Customer]\n"
                        + "           ([email]\n"
                        + "           ,[name]\n"
                        + "           ,[birth_date]\n"
                        + "           ,[phone_number]\n"
                        + "           ,[address]\n"
                        + "           ,[status]\n"
                        + "           ,[orders]\n"
                        + "           ,[flag])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?,?,?,?)";
                pts = con.prepareStatement(sql);
                pts.setString(1, email);
                pts.setString(2, name);
                
                pts.setDate(3, java.sql.Date.valueOf(birth_date));
                pts.setString(4, phone_number);
                pts.setString(5, address);
               
                pts.setBoolean(6, status);
                pts.setString(7, orders);
                pts.setInt(8, flag);
                result = pts.executeUpdate();
            }
        } catch (Exception e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (pts != null) {
                try {
                    pts.close();
                } catch (SQLException e) {
                    // Handle the exception
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // Handle the exception
                }
            }
        }
        return result;
    }

}
