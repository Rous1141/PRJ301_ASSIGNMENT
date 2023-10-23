<%-- 
    Document   : checkLogin

    Created on : Oct 18, 2023, 9:24:09 AM
    Author     : bolic

--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.CustomerDAO"%>
<%@page import="DTO.Customers"%>
<%@page import="DAO.LoginDAO"%>
<%@page import="DTO.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checking Page</title>
    </head>
    <body>
        <%
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            Login result = LoginDAO.LogIn(email, pass);
            ArrayList<Customers> user = new ArrayList<>();

            user = CustomerDAO.getCustomersByEmail(email);

            String URL = "../CentralController";
            String role = "";
            if (result != null) {
                session = request.getSession(); // GET CURRENT USER SESSION
                session.setAttribute("role", result.getRole());
                session.setAttribute("user", result);
                switch (result.getRole()) {
                    case "AD": {
                        role = "admin";
                        request.setAttribute("role", role);
                        request.getRequestDispatcher(URL).forward(request, response);
                        break;
                    }
                    case "SH": {
                        role = "shipper";
                        request.setAttribute("role", role);
                        request.getRequestDispatcher(URL).forward(request, response);
                        break;
                    }
                    case "CS": {
                        role = "shop";
                        for (Customers cus : user) {
                            if (cus.getStaus() != true) {
                                role = "welcome";
        %>
        <h3>User Is Banned. See You In 2 Weeks!</h3>
        <%
                            break;
                        }else{
                    request.setAttribute("role", role);
                    request.getRequestDispatcher(URL).forward(request, response);
}
                    }
                   
                    break;
                }
            }

        } else {
            if (email == null && pass == null) {
        %>
        <h3 style="color: yellow">Please Log In To Continue</h3>
        <%
        } else {

        %>
        <h3>User Doesn't Exist</h3>
        <%                }
            }

        %>
    </body>
</html>
