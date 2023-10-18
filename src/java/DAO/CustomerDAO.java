/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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

                    Customers emp = new Customers(id, name, birth, phone, add, mail, staus, orders);

                    result.add(emp);
                }
                con.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return result;
    }
}
