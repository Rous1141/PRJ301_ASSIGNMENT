<%-- 
    Document   : profilePage
    Created on : Nov 1, 2023, 3:28:00 PM
    Author     : hendrix
--%>
<%@page import="DTO.Login"%>
<%@page import="DTO.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DTO.Customers"%>
<%@page import="DAO.CustomerDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>

        <div>

            <%
                Login l = (Login) session.getAttribute("result");
                if (l != null) {
                    String email = l.getEmail();
                    ArrayList<Customers> customersList = CustomerDAO.getCustomersByEmail(email);
                    for (Customers customer : customersList) {
            %>
            <h1>My Profile</h1>
            <div>
                
                <p>Name: <%= customer.getName()%></p>
                <p>Email: <%= customer.getEmail()%></p>
                <p>Birth Date: <%= customer.getBirth_date()%></p>
                <p>Phone Number: <%= customer.getPhone_number()%></p>
                <p>Address: <%= customer.getAddress()%></p>
                <p>Status: <%= customer.getStaus()%></p>
                <p>Orders: <%= customer.getOrders()%></p>
                <p>Flag: <%= customer.getFlag()%></p>
            </div>
            <%
                }
            } else {
            %>
            <p>Not Found.</p>
            <%
                }
            %>
        </div>
    </body>
</html>
