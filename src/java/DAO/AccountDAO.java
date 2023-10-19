/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Account;
import myLibrary.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author bolic
 */
public class AccountDAO {

    public static Account getAccount(String email, String password) throws Exception {
        Account result = null;
        Connection cn = DatabaseConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT [email]\n"
                    + "      ,[password]\n"
                    + "      ,[role]\n"
                    + "  FROM [flower_shop].[dbo].[Account]\n"
                    + "  where [email] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String e = rs.getString("email");
                String pwd = rs.getString("password");
                String role = rs.getString("role");

                result = new Account(e, pwd, role);
            }
            cn.close();
        }
        return result;
    }

    public static int insertAccount(String email, String password, String role) throws Exception {
        int rs = 0;
        Connection cn = DatabaseConnection.makeConnection();
        if (cn != null) {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([email]\n"
                    + "           ,[password]\n"
                    + "           ,[role])\n"
                    + "     VALUES(?,?,?)\n";

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            pst.setString(3, "CS");
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
