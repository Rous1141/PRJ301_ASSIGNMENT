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
import java.util.ArrayList;
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

}
