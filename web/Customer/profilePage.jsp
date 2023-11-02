<%-- 
    Document   : profilePage
    Created on : Nov 1, 2023, 3:28:00 PM
    Author     : hendrix
--%>
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
        <h1>My Profile</h1>
        <div>
            <%
                
                Customers cusEmail = (Customers) session.getAttribute("user");
                ArrayList<Customers> result = CustomerDAO.getCustomersByEmail(cusEmail.getEmail());
            for ( Customers r : result) {
             
            
            %>
            <div>
            <p><%= r.getName() %></p>
            <p>Email: <%= r.getEmail() %></p>
            <p>Birth Date: <%= r.getBirth_date() %></p>
            <p>Phone Number: <%= r.getPhone_number() %></p>
            <p>Address: <%= r.getAddress() %></p>
            <p>Status: <%= r.getStaus() %></p>
            <p>Orders: <%= r.getOrders() %></p>
            <p>Flag: <%= r.getFlag() %></p>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
