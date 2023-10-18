/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import myLibrary.DatabaseConnection;

/**
 *
 * @author hendrix
 */
public class LoginDAO {

    public static Login LogIn(String email, String password) {
        Login result = null;
        Connection con;
        try {
            con = DatabaseConnection.makeConnection();
            if (con != null) {
                String sql = "select [email],[password],[role] from [dbo].[Account]\n" +
                "where email = ? and password = ?";

                PreparedStatement pts = con.prepareStatement(sql);
                pts.setString(1, email);
                pts.setString(2, password);
                ResultSet rs = pts.executeQuery();
                while (rs != null && rs.next()) {
                    String mail = rs.getString("email");
                    String pass = rs.getString("password");
                    String role = rs.getString("role");
                    result = new Login(mail, pass, role);
                }
                con.close();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
