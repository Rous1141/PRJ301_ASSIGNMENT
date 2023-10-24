<%-- 
    Document   : updateStatus
    Created on : Oct 23, 2023, 3:06:30 PM
    Author     : hendrix
--%>

<%@page import="DAO.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            Status
        </title>
    </head>
    <body>
        <%
            int ID = Integer.parseInt(request.getParameter("ID"));
            int flag = Integer.parseInt(request.getParameter("flag"));
            boolean status = Boolean.parseBoolean(request.getParameter("status"));
            if(ID == 0){ request.setAttribute("role", "error");request.getRequestDispatcher("CentralController").forward(request, response); } //ERROR PAGE
            int Update = CustomerDAO.updateCustomerStatus(ID,flag,status);
            
        %>
    </body>
</html>
