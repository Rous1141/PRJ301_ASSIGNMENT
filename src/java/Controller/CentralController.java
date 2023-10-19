/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hendrix
 */
public class CentralController extends HttpServlet {
            String SignUp_Page = "/Customer/signupPage.jsp";
            String LogIn_Page = "/Components/loginPage.jsp";
            String Shop_Page = "/Customer/shopPage.jsp";
            String Admin_Page = "/Admin/adminPage.jsp";
            String Cart_Page = "/Customer/cartPage.jsp";
            String History_Page = "/Customer/historyPage.jsp";
            String Shipper_Page = "/Shipper/shipperPage.jsp";
            String Error_Page = "/Components/errorPage.jsp";
           
            
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

            String SignIn_Page = "/Customer/signupPage.jsp";
            String LogIn_Page = "/Components/loginPage.jsp";
            String Shop_Page = "/Customer/shopPage.jsp";
            String Admin_Page = "/Admin/adminPage.jsp";
            String Cart_Page = "/Customer/cartPage.jsp";
            String History_Page = "/Customer/historyPage.jsp";
            String Shipper_Page = "/Components/shipperPage.jsp";
            String Error_Page = "/Components/errorPage.jsp";

            

            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            String role = (String) request.getAttribute("role");

            
            if(action == null){action="welcome";}
            if(role != null){
                action = role; request.removeAttribute("role");
            }



            switch (action) {
                
                case "welcome":{request.getRequestDispatcher(LogIn_Page).forward(request, response);break;}
                case "shop":{request.getRequestDispatcher(Shop_Page).forward(request, response);break;}
                case "signup":{request.getRequestDispatcher(SignIn_Page).forward(request, response);break;}
                case "cart":{request.getRequestDispatcher(Cart_Page).forward(request, response);break;}
                case "history":{request.getRequestDispatcher(History_Page).forward(request, response);break;}
                case "admin":{request.getRequestDispatcher(Admin_Page).forward(request, response);break;}
                case "shipper":{request.getRequestDispatcher(Shipper_Page).forward(request, response);break;}

                default:
                     request.getRequestDispatcher(Error_Page).forward(request, response);{break;}

            }
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
