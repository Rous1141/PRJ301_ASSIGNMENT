/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myLibrary.DatabaseConnection;

/**
 *
 * @author bolic
 */
public class LoginPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Ki?m tra thông tin ??ng nh?p
            Connection con;
            try {
                con = DatabaseConnection.makeConnection();
                if (con != null) {
                    String sql = "select [email],[password],[role]\n"
                            + "From [dbo].[Account]\n"
                            + "Where  email = ? AND password = ?";

                    PreparedStatement pts = con.prepareStatement(sql);
                    pts.setString(1, email);
                    pts.setString(2, password);
                    ResultSet rs = pts.executeQuery();
                    while (rs != null && rs.next()) {
                        String mail = rs.getString("email");
                        String pass = rs.getString("password");
                        String role = rs.getString("role");

                        // N?u thông tin ??ng nh?p chính xác
                        if (email.equals(mail) && password.equals(pass)) {
                            // L?u thông tin ng??i dùng vào session
                            request.getSession().setAttribute("email", email);
                            request.getSession().setAttribute("password", password);
                            request.getSession().setAttribute("role", role);

                            // Chuy?n sang trang t??ng ?ng
                            switch (role) {
                                case "AD":
                                    // Chuy?n sang trang Admin.jsp
                                    request.getRequestDispatcher("/Admin/adminPage.jsp").forward(request, response);
                                    break;
                                case "SH":
                                    // Chuy?n sang trang shipper.jsp
                                    request.getRequestDispatcher("/shipperPage.jsp").forward(request, response);
                                    break;
                                case "CS":
                                    // Chuy?n sang trang customer.jsp
                                    request.getRequestDispatcher("/Customer/customer.jsp").forward(request, response);
                                    break;
                                default:
                                    // N?u không có role phù h?p thì s? chuy?n v? trang login.jsp
                                    request.getRequestDispatcher("/Components/loginPage.jsp").forward(request, response);
                                    break;
                            }
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            // N?u thông tin ??ng nh?p không chính xác
            // Tr? v? trang loginPage.jsp
            request.getRequestDispatcher("/Components/loginPage.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
