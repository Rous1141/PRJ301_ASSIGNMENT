/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import myLibrary.DatabaseConnection;

/**
 *
 * @author hendrix
 */
public class AdminDAO {

    public static Admin getAccount(String email) throws Exception {
        Admin result = null;
        Connection cn = DatabaseConnection.makeConnection();
        if (cn != null) {
            String sql = "SELECT [admin_id]\n"
                    + "      ,[name]\n"
                    + "      ,[phone_number]\n"
                    + "      ,[address]\n"
                    + "      ,[email]\n"
                    + "      ,[password]\n"
                    + "      ,[role]\n"
                    + "      ,[account_id]\n"
                    + "  FROM [flower_shop].[dbo].[Admin]\n"
                    + "  where [email] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
               
                String name = rs.getString("name");
                

                result = new Admin(0, 0, name, "NA", "NA", "NA", "NA", "AD");
            }
            cn.close();
        }
        return result;
    }
}
