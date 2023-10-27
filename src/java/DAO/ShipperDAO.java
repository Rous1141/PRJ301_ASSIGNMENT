/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Shippers;
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
public class ShipperDAO {

    public static ArrayList<Shippers> getAll() throws Exception {
        Connection con;

        ArrayList<Shippers> result = new ArrayList<>();
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
                        + "       ,[[order_assigned]]\n"
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
                   
                    int order_assigned = rs.getInt("[order_assigned]");
                    
                    Shippers ship = new Shippers(id, name, birth, phone, orders, mail, add, staus, order_assigned);
        result.add(ship);
                }
                con.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return result;
    }
    
    public static int updateShipper(String email,int order) throws Exception {
        int result = 0;
        try{
            Connection cn = DatabaseConnection.makeConnection();
        
        if (cn != null) {
            String sql = "UPDATE [dbo].[Shipper]\n" +
                            " SET [Order_Assigned] = ? \n" +
                            " WHERE [email] = ? ";
    
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, order);
            pst.setString(2, email);
           
            result = pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
